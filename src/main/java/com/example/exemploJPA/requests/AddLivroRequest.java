package com.example.exemploJPA.requests;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.exemploJPA.model.entities.Livro;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddLivroRequest {
    private String nome;

    private Number editoraId;

    private Number categoriaId;

    private List<Number> autoresId;

    private Date dataLancamento;

    @JsonCreator
    public AddLivroRequest(@JsonProperty("nome") String nome,
            @JsonProperty("editoraId") Number editoraId,
            @JsonProperty("categoriaId") Number categoriaId,
            @JsonProperty("autoresId") List<Number> autoresId,
            @JsonProperty("dataLancamento") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date dataLancamento) {
        this.nome = nome;
        this.editoraId = editoraId;
        this.categoriaId = categoriaId;
        this.autoresId = autoresId;
        this.dataLancamento = dataLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public Number getEditoraId() {
        return editoraId;
    }

    public void setEditoraId(Number editoraId) {
        this.editoraId = editoraId;
    }

    public Number getCategoriaId() {
        return categoriaId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setCategoriaId(Number categoriaId) {
        this.categoriaId = categoriaId;
    }

    public List<Number> getAutoresId() {
        return autoresId;
    }

    public void setAutoresId(List<Number> autoresId) {
        this.autoresId = autoresId;
    }

}
