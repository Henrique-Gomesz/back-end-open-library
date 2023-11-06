package com.example.exemploJPA.db.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="autor")
public class Autor {
    @Id
    @Column(name="aut_id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(name="aut_nome")
    private String nome;
    @Column(name="aut_nacionalidade")
    private String nacionalidade;

    @ManyToMany(mappedBy = "autores", fetch = FetchType.LAZY)
    private List<Livro> livros;

    public Autor() {
    }

    public Autor(Long id, String nome, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

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

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
