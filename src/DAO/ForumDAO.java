package DAO;

import commons.Console;
import entities.Forum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.ConnectionFactory;

public class ForumDAO {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    private Connection connection;
    
    public ForumDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public ArrayList<Forum> localizarForum(Integer idDorama) throws SQLException {
        ArrayList<Forum> listaForum = new ArrayList<Forum>();
        Forum forum;
        String sql = "SELECT F.idForum, F.idDorama, F.idUsuario, F.comentario, F.dataComent, U.nomeUsuario FROM FORUM F,usuario U WHERE idDorama = "
                + idDorama +"and F.idUsuario = U.idUsuario ORDER BY dataComent";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                forum = new Forum();
                forum.setIdForum(rs.getInt("idForum"));
                forum.setIdDorama(rs.getInt("idDorama"));
                forum.setIdUsuario(rs.getInt("idUsuario"));
                forum.setComentario(rs.getString("comentario"));
                forum.setDataComent(rs.getDate("dataComent"));
                forum.setNomeUsuario(rs.getString("nomeUsuario"));
                listaForum.add(forum);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
        return listaForum;
    }
    
    public void adicionaComentario(Forum forum) throws RuntimeException {
        String sql = "insert into Forum (idDorama, idUsuario, comentario, dataComent) " +
                     "values (?,?,?, sysdate)";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);

            stmt.setInt(1, forum.getIdDorama());
            stmt.setInt(2, forum.getIdUsuario());
            stmt.setString(3, forum.getComentario());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
