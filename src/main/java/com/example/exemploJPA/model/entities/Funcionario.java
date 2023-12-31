package com.example.exemploJPA.model.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Funci_id")
    private Long funciId;

    @ManyToOne
    @JoinColumn(name = "Usu_id")
    private Usuario usuario;

    @Column(name = "Funci_cargo", nullable = false)
    private String funciCargo;

    @Column(name = "Funci_dataADM", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date funciDataADM;

    @Column(name = "Funci_dataDEM")
    @Temporal(TemporalType.DATE)
    private Date funciDataDEM;

    public Long getFunciId() {
        return funciId;
    }

    public void setFunciId(Long funciId) {
        this.funciId = funciId;
    }

    public String getFunciCargo() {
        return funciCargo;
    }

    public void setFunciCargo(String funciCargo) {
        this.funciCargo = funciCargo;
    }

    public Date getFunciDataADM() {
        return funciDataADM;
    }

    public void setFunciDataADM(Date funciDataADM) {
        this.funciDataADM = funciDataADM;
    }

    public Date getFunciDataDEM() {
        return funciDataDEM;
    }

    public void setFunciDataDEM(Date funciDataDEM) {
        this.funciDataDEM = funciDataDEM;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
