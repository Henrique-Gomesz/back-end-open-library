package com.example.exemploJPA.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "autoreslivros")
public class AutorLivro {

    @Id
    @JoinColumn(name = "autor_id")
    private Long autorId;

    @Id
    @JoinColumn(name = "livro_id")
    private Long livroId;

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

}
