package entities;

import java.sql.Date;

public class Forum {
    private Integer idForum;
    private Integer idDorama;
    private Integer idUsuario;
    private String comentario;
    private Date dataComent;
    private String nomeUsuario;

    public Forum(Integer idForum, Integer idDorama, Integer idUsuario, String comentario, Date dataComent, String nomeUsuario) {
        this.idForum = idForum;
        this.idDorama = idDorama;
        this.idUsuario = idUsuario;
        this.comentario = comentario;
        this.dataComent = dataComent;
        this.nomeUsuario = nomeUsuario;
    }
    
    public Forum() {
    }

    public Forum(Integer idForum, Integer idDorama, Integer idUsuario, String comentario, Date dataComent) {
        this.idForum = idForum;
        this.idDorama = idDorama;
        this.idUsuario = idUsuario;
        this.comentario = comentario;
        this.dataComent = dataComent;
    }

    public Forum(Integer idDorama, Integer idUsuario, String comentario, Date dataComent) {
        this.idDorama = idDorama;
        this.idUsuario = idUsuario;
        this.comentario = comentario;
        this.dataComent = dataComent;
    }
    
    public Forum(Integer idDorama, Integer idUsuario, String comentario) {
        this.idDorama = idDorama;
        this.idUsuario = idUsuario;
        this.comentario = comentario;
    }

    public Integer getIdForum() {
        return idForum;
    }

    public void setIdForum(Integer idForum) {
        this.idForum = idForum;
    }

    public Integer getIdDorama() {
        return idDorama;
    }

    public void setIdDorama(Integer idDorama) {
        this.idDorama = idDorama;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getDataComent() {
        return dataComent;
    }

    public void setDataComent(Date dataComent) {
        this.dataComent = dataComent;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    
    

    
}
