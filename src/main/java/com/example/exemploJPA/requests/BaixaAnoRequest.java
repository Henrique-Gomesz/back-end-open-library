package com.example.exemploJPA.requests;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.exemploJPA.model.entities.Baixa;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BaixaAnoRequest {

    private Integer anoBaixa;

    @JsonCreator
    public BaixaAnoRequest(
            @JsonProperty("anoBaixa") Integer anoBaixa) {
        this.anoBaixa = anoBaixa;
    }



    public Integer getAnoBaixa() {
        return this.anoBaixa;
    }

    public void setAnoBaixa(Integer anoBaixa) {
        this.anoBaixa = anoBaixa;
    }


    public Integer toDomain() {
        return this.anoBaixa;
    }
}
