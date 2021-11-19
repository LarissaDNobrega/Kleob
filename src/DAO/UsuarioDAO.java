package DAO;

import commons.Console;
import entities.Usuario;
import model.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

public class UsuarioDAO {

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    private Connection connection;

    public static void main(String[] args) throws SQLException {
        /*UsuarioDAO usuarioDAO = new UsuarioDAO();

        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
        listaUsuario = usuarioDAO.localizarUsuarios();

        for (Usuario usuario : listaUsuario) {
            Console.escreve(usuario.getEmail());

        }
        
        String dataStr = "13/07/2000";

        String temp = dataStr;
        dataStr = temp.substring(6,10) + "-" + temp.substring(3,5) + "-" + temp.substring(0,2);

        Date date= Date.valueOf(dataStr);

        Usuario usuario = new Usuario("Android29","Matheus Lima", "12345","android29@gmail.com",date);
        usuarioDAO.adicionaUsuario(usuario);*/
        
    }

    public UsuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public Connection getConnection() {
        return connection;
    }
    
    public String validarAcesso(String email){
        String sql = "SELECT senha FROM USUARIO WHERE email = '" + email + "'";
        String senha = "default";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                senha = rs.getString("senha");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        
    }
     return senha;
    }

    public ArrayList<Usuario> localizarUsuarios() throws SQLException {
        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
        Usuario usuario;
        String sql = "SELECT * FROM USUARIO";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNomeUsuario(rs.getString("nomeUsuario"));
                usuario.setNomeCompleto(rs.getString("nomeCompleto"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDataNascimento(rs.getDate("dataNascimento"));
                usuario.setDataCadastro(rs.getDate("dataCadastro"));
                listaUsuario.add(usuario);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listaUsuario;
    }
    
    public Usuario selecionaUsuario(String email) throws SQLException {
        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
        Usuario usuario = null;
        String sql = "SELECT * FROM USUARIO WHERE email = '" + email +"'";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNomeUsuario(rs.getString("nomeUsuario"));
                usuario.setNomeCompleto(rs.getString("nomeCompleto"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDataNascimento(rs.getDate("dataNascimento"));
                usuario.setDataCadastro(rs.getDate("dataCadastro"));
                listaUsuario.add(usuario);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return usuario;
    }
    
    public void adicionaUsuario(Usuario usuario) throws RuntimeException {
        String sql = "insert into USUARIO (nomeUsuario, nomeCompleto, senha, email, dataNascimento, dataCadastro) " +
                     "values (?,?,?,?,?,sysdate)";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);

            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getNomeCompleto());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getEmail());
            stmt.setDate(5, usuario.getDataNascimento());
           
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
