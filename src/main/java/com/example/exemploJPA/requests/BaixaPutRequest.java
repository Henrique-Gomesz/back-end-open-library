package com.example.exemploJPA.requests;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.exemploJPA.model.entities.Baixa;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BaixaPutRequest {
    
    private Long baixaId;
    private Long exempId;
    private Long funciId;
    private String motivoBaixa;
    private String descBaixa;
    private Date dataBaixa;

    @JsonCreator
    public BaixaPutRequest(@JsonProperty("baixaId") Long baixaId,
            @JsonProperty("exempId") Long exempId, @JsonProperty("funciId") Long funciId, @JsonProperty("motivoBaixa") String motivoBaixa, @JsonProperty("descBaixa") String descBaixa, @JsonProperty("dataBaixa") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date dataBaixa) {
        this.baixaId = baixaId;
        this.exempId = exempId;
        this.funciId = funciId;
        this.motivoBaixa = motivoBaixa;
        this.descBaixa = descBaixa;
        this.dataBaixa = dataBaixa;
    }

    public Long getBaixaId() {
        return this.baixaId;
    }

    public void setBaixaId(Long baixaId) {
        this.baixaId = baixaId;
    }


    public Long getExempId() {
        return this.exempId;
    }

    public void setExempId(Long exempId) {
        this.exempId = exempId;
    }

    public Long getFunciId() {
        return this.funciId;
    }

    public void setFunciId(Long funciId) {
        this.funciId = funciId;
    }

    public String getMotivoBaixa() {
        return this.motivoBaixa;
    }

    public void setMotivoBaixa(String motivoBaixa) {
        this.motivoBaixa = motivoBaixa;
    }

    public String getDescBaixa() {
        return this.descBaixa;
    }

    public void setDescBaixa(String descBaixa) {
        this.descBaixa = descBaixa;
    }

    public Date getDataBaixa() {
        return this.dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }


    public Baixa toDomain() {
        Baixa baixa = new Baixa();
        
        baixa.setBaixaId(this.baixaId);
        baixa.setExempId(this.exempId);
        baixa.setFunciId(this.funciId);
        baixa.setMotivoBaixa(this.motivoBaixa);
        baixa.setBaixaDesc(this.descBaixa);
        baixa.setDataBaixa(this.dataBaixa);
        
        return baixa;
    }
}
