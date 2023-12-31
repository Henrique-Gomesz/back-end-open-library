package com.example.exemploJPA.model.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "exemplar")
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exemp_id")
    private Long id;

    @Column(name = "livro_id")
    private Long livroId;

    @Column(name = "exemp_status")
    private String statusExemplar;

    @Column(name = "exemp_data")
    @Temporal(TemporalType.DATE)
    private Date dataExemplar;

    @Column(name = "exemp_edicao")
    private String edicao;

    @Column(name = "exemp_anopubli")
    private Integer anoPublicacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public String getStatusExemplar() {
        return statusExemplar;
    }

    public void setStatusExemplar(String statusExemplar) {
        this.statusExemplar = statusExemplar;
    }

    public Date getDataExemplar() {
        return dataExemplar;
    }

    public void setDataExemplar(Date dataExemplar) {
        this.dataExemplar = dataExemplar;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }



}
