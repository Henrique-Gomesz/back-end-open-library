package com.example.exemploJPA.requests;

import com.example.exemploJPA.model.entities.Exemplar;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExemplarGetDeleteRequest {

    private Long exempId;

    @JsonCreator
    public ExemplarGetDeleteRequest(
            @JsonProperty("exempId") Long exempId) {
        this.exempId = exempId;
    }


    public Long getexempIs() {
        return this.exempId;
    }

    public void setexempId(Long exempId) {
        this.exempId = exempId;
    }


    public Long toDomain() {
        Exemplar Exemplar = new Exemplar();
        
        Exemplar.setId(exempId);
        
        return Exemplar.getId();
    }
}
