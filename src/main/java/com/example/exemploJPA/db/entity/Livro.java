package com.example.exemploJPA.db.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="liv_id")
    private Long id;
    @Column(name="liv_titulo")
    private String titulo;

    @ManyToOne
    @JoinColumn(name="edi_id",nullable = false)
    private Editora editora;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="livro_autor",joinColumns = @JoinColumn(name="liv_id"),
               inverseJoinColumns = @JoinColumn(name="aut_id"))
    private List<Autor> autores;

    @OneToMany(mappedBy = "livro")
    private List<Capitulo> capitulos;

    public Livro() {
    }

    public Livro(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }
    @OneToMany(mappedBy = "livro")
    private List<EmpLivro> emprestados;

}
