package com.example.exemploJPA.requests;

import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator;

public class BaixaAnoRequest {

    private Integer anoBaixa;

    @JsonCreator
    public BaixaAnoRequest(
            @RequestParam("anoBaixa") Integer anoBaixa) {
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
