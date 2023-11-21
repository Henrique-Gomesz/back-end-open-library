package com.example.exemploJPA.requests;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddLivroRequest {
    private String nome;

    private Integer editoraId;

    private Integer categoriaId;

    private List<Integer> autoresId;

    private Date dataLancamento;

    @JsonCreator
    public AddLivroRequest(@JsonProperty("nome") String nome,
            @JsonProperty("editoraId") Integer editoraId,
            @JsonProperty("categoriaId") Integer categoriaId,
            @JsonProperty("autoresId") List<Integer> autoresId,
            @JsonProperty("dataLancamento") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataLancamento) {
        this.nome = nome;
        this.editoraId = editoraId;
        this.categoriaId = categoriaId;
        this.autoresId = autoresId;
        this.dataLancamento = dataLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEditoraId() {
        return editoraId;
    }

    public void setEditoraId(Integer editoraId) {
        this.editoraId = editoraId;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public List<Integer> getAutoresId() {
        return autoresId;
    }

    public void setAutoresId(List<Integer> autoresId) {
        this.autoresId = autoresId;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

}
