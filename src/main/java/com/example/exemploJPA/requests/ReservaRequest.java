package com.example.exemploJPA.requests;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservaRequest {

    private Long FuncionarioID;

    private String UsuarioCPF;

    private Long LivrosID;

    private Date dataReserva;

    @JsonCreator
    public ReservaRequest( @JsonProperty("FuncionarioID") Long FuncionarioID,
                           @JsonProperty("UsuarioCPF") String UsuarioCPF,
                           @JsonProperty("LivrosID") Long LivrosID,
                           @JsonProperty("dataReserva") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataReserva) {
        this.FuncionarioID = FuncionarioID;
        this.UsuarioCPF = UsuarioCPF;
        this.LivrosID = LivrosID;
        this.dataReserva = dataReserva;
    }

    public Long getFuncionarioID() {
        return FuncionarioID;
    }

    public void setFuncionarioID(Long funcionarioID) {
        FuncionarioID = funcionarioID;
    }

    public String getUsuarioCPF() {
        return UsuarioCPF;
    }

    public void setUsuarioCPF(String usuarioCPF) {
        UsuarioCPF = usuarioCPF;
    }

    public Long getLivrosID() {
        return LivrosID;
    }

    public void setLivrosID(Long livrosID) {
        LivrosID = livrosID;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }
}
