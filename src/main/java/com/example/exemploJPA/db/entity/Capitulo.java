package com.example.exemploJPA.db.entity;

import jakarta.persistence.*;
@Entity
@Table(name="capitulo")
public class Capitulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cap_id")
    private int id;
    @Column(name="cap_numero")
    private int numero;
    @Column(name="cap_titulo")
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="liv_id")
    private Livro livro;

    public Capitulo() {
    }

    public Capitulo(int id, int numero, String titulo) {
        this.id = id;
        this.numero = numero;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
