package com.example.exemploJPA.requests;

import com.example.exemploJPA.model.entities.Autor;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AutorRequest {
    private String nome;

    @JsonCreator
    public AutorRequest(
            @JsonProperty("nome") String nome) {
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public Autor toDomain() {
        Autor autor = new Autor();
        autor.setAutorNome(this.getNome());

        return autor;
       
    }
}
