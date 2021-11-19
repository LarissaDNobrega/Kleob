package entities;

import java.sql.Date;

public class Dorama {
    private Integer idDorama;
    private String titulo;
    private String descricao;
    private Float nota;
    private String genero;
    private Date dataLancamento;
    private String imagem;
    private Integer episodio;

    public Dorama(Integer idDorama, String titulo, String descricao, Float nota, String genero, Date dataLancamento, String imagem, Integer episodio) {
        this.idDorama = idDorama;
        this.titulo = titulo;
        this.descricao = descricao;
        this.nota = nota;
        this.genero = genero;
        this.dataLancamento = dataLancamento;
        this.imagem = imagem;
        this.episodio = episodio;
    }

    public Dorama() {
    }
    

    public Integer getIdDorama() {
        return idDorama;
    }

    public void setIdDorama(Integer idDorama) {
        this.idDorama = idDorama;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getEpisodio() {
        return episodio;
    }

    public void setEpisodio(Integer episodio) {
        this.episodio = episodio;
    }

    
}
