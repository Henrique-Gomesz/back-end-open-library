package com.example.exemploJPA.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@IdClass(AutoresLivrosId.class)
@Table(name = "AutoresLivros")
public class AutorLivro {

    @Id
    @Column(name = "Autor_id")
    private Long autorId;

    @Id
    @Column(name = "Livro_id")
    private Long livroId;

    @ManyToOne
    @JoinColumn(name = "Autor_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "Livro_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Livro livro;

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    
}
