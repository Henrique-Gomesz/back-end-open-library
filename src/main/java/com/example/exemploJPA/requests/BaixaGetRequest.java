package com.example.exemploJPA.requests;

import com.example.exemploJPA.model.entities.Baixa;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BaixaGetRequest {

    private Long baixaId;

    @JsonCreator
    public BaixaGetRequest(
            @JsonProperty("baixaId") Long baixaId) {
        this.baixaId = baixaId;
    }


    public Long getBaixaId() {
        return this.baixaId;
    }

    public void setBaixaId(Long baixaId) {
        this.baixaId = baixaId;
    }


    public Long toDomain() {
        Baixa baixa = new Baixa();
        
        baixa.setBaixaId(this.baixaId);
        
        return baixa.getBaixaId();
    }
}
