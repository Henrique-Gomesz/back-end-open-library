package com.example.exemploJPA.requests;

import com.example.exemploJPA.model.entities.Baixa;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BaixaMotivoRequest {
    

    private String motivoBaixa;


    @JsonCreator
    public BaixaMotivoRequest(@JsonProperty("motivoBaixa") String motivoBaixa) {

        this.motivoBaixa = motivoBaixa;

    }

  

    public String getMotivoBaixa() {
        return this.motivoBaixa;
    }

    public void setMotivoBaixa(String motivoBaixa) {
        this.motivoBaixa = motivoBaixa;
    }


    public String toDomain() {
        Baixa baixa = new Baixa();
        

        baixa.setMotivoBaixa(this.motivoBaixa);

        
        return baixa.getMotivoBaixa();
    }
}
