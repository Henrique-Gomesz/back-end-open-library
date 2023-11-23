package com.example.exemploJPA.requests;

import com.example.exemploJPA.model.entities.Exemplar;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExemplarStatusRequest {

    private String statusExemplar;


    @JsonCreator
    public ExemplarStatusRequest(
           @JsonProperty("exempStatus") String statusExemp) {

        this.statusExemplar = statusExemp;

    }



    public String getStatusExemplar() {
        return this.statusExemplar;
    }

    public void setStatusExemplar(String statusExemplar) {
        this.statusExemplar = statusExemplar;
    }




    public String toDomain() {
        Exemplar exemplar = new Exemplar();

        exemplar.setStatusExemplar(statusExemplar);
        
        return exemplar.getStatusExemplar();
    }
}
