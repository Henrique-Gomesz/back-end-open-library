package com.example.exemploJPA.requests;

import com.example.exemploJPA.model.entities.Categoria;
import com.example.exemploJPA.model.entities.EnumCategorias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddCategoriaRequest {
    private String nome;

    @JsonCreator
    public AddCategoriaRequest(
            @JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void setName(String nome) {
        this.nome = nome;
    }

    public Categoria toDomain() {
        Categoria categoria = new Categoria();
        categoria.setNome(EnumCategorias.valueOf(this.nome));

        return categoria;
       
    }
}
