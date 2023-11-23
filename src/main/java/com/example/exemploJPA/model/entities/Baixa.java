package com.example.exemploJPA.model.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "baixa")
public class Baixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baixa_id")
    private Long baixaId;

    @Column(name = "exemp_id")
    private Long exempId;

    @Column(name = "funci_id")
    private Long funciId;

    @Column(name = "baixa_motivo")
    private String motivoBaixa;

    @Column(name = "baixa_desc")
    private String baixaDesc;

    @Column(name = "baixa_data")
    @Temporal(TemporalType.DATE)
    private Date dataBaixa;


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

    public String getBaixaDesc() {
        return this.baixaDesc;
    }

    public void setBaixaDesc(String baixaDesc) {
        this.baixaDesc = baixaDesc;
    }

    public Date getDataBaixa() {
        return this.dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }


    
}
