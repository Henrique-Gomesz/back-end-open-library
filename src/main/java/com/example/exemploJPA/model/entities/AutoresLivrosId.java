package com.example.exemploJPA.model.entities;

import java.io.Serializable;

public class AutoresLivrosId implements Serializable {

    private Long autorId;
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
