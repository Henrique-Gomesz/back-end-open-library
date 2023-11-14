package com.example.exemploJPA.model.entities;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Exemplar")
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Exemp_id")
    private Long id;

    @Column(name = "Livro_id")
    private Long livroId;

    @Column(name = "Exemp_status")
    @Enumerated(EnumType.STRING)
    private StatusExemplares statusExemplar;

    @Column(name = "Exemp_data")
    @Temporal(TemporalType.DATE)
    private Date dataExemplar;

    @Column(name = "Exemp_edicao")
    private String edicao;

    @Column(name = "Exemp_anoPubli")
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

    public StatusExemplares getStatusExemplar() {
        return statusExemplar;
    }

    public void setStatusExemplar(StatusExemplares statusExemplar) {
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
