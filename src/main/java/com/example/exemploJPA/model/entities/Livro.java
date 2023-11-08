package com.example.exemploJPA.model.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Livro_nome", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "Editora_id", nullable = false)
    private Editora editora;

    @Column(name = "Lanca_ano", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date lancamentoAno;

    @Column(name = "Edicao", nullable = false)
    private String edicao;

    @ManyToOne
    @JoinColumn(name = "Genero", nullable = false)
    private Categoria genero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Date getLancamentoAno() {
        return lancamentoAno;
    }

    public void setLancamentoAno(Date lancamentoAno) {
        this.lancamentoAno = lancamentoAno;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

   
}
