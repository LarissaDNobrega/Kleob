/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import commons.Console;
import entities.Dorama;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.ConnectionFactory;

/**
 *
 * @author Aluno
 */
public class DoramaDAO {
    
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    private Connection connection;
    
    /*public static void main(String[] args) throws SQLException {
        DoramaDAO doramaDAO = new DoramaDAO();

        ArrayList<Dorama> listaDorama = new ArrayList<Dorama>();
        listaDorama = doramaDAO.localizarDorama();

        /*for (Dorama dorama : listaDorama) {
            Console.escreve(dorama.getTitulo());

    }*/
    
    public DoramaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public ArrayList<Dorama> localizarDorama() throws SQLException {
        ArrayList<Dorama> listaDorama = new ArrayList<Dorama>();
        Dorama dorama;
        String sql = "SELECT * FROM DORAMA ORDER BY titulo";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                dorama = new Dorama();
                dorama.setIdDorama(rs.getInt("idDorama"));
                dorama.setTitulo(rs.getString("titulo"));
                dorama.setDescricao(rs.getString("descricao"));
                dorama.setNota(rs.getFloat("nota"));
                dorama.setGenero(rs.getString("genero"));
                dorama.setDataLancamento(rs.getDate("dataLancamento"));
                dorama.setImagem(rs.getString("imagem"));
                dorama.setEpisodio(rs.getInt("episodios"));
                listaDorama.add(dorama);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listaDorama;
    }
    
    public void adicionaDorama(Dorama dorama) throws RuntimeException {
        String sql = "insert into Dorama (titulo, descricao, nota, genero, dataLancamento, imagem, episodios) " +
                     "values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);

            stmt.setString(1, dorama.getTitulo());
            stmt.setString(2, dorama.getDescricao());
            if(dorama.getNota() == null)
                stmt.setNull(3,java.sql.Types.FLOAT);
            else
                stmt.setFloat(3,dorama.getNota());
                       
            if(dorama.getGenero() == null)
                stmt.setNull(4,java.sql.Types.VARCHAR);
            else
                stmt.setString(4,dorama.getGenero());
                        
            if(dorama.getDataLancamento()== null)
                stmt.setNull(5,java.sql.Types.DATE);
            else
                stmt.setDate(5,dorama.getDataLancamento());
            
            if(dorama.getImagem()== null)
                stmt.setString(6,"default.jpeg");
            else
                stmt.setString(6,dorama.getImagem());
            
            stmt.setInt(7, dorama.getEpisodio());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
