package com.example.exemploJPA.db.entity;

import jakarta.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cli_id")
    private Long id;
    @Column(name="cli_nome")
    private String nome;

    public Cliente() {
    }

    public Cliente(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
