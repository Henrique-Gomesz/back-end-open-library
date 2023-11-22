package com.example.exemploJPA.requests;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.exemploJPA.model.entities.Exemplar;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExemplarAnoRequest {


    private Integer anoPublicacao;


    @JsonCreator
    public ExemplarAnoRequest(
            @JsonProperty("anoPublicacao") Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
            }


   
    public Integer getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Integer toDomain() {
        Exemplar exemplar = new Exemplar();
        
        exemplar.setAnoPublicacao(anoPublicacao);
        
        return exemplar.getAnoPublicacao();
    }
}
