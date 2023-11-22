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

@Entity
@Table(name = "Endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ende_id")
    private Long EnderecoID;

    @Column(name = "Ende_pais")
    private String Pais;

    @Column(name = "Ende_estado")
    private String Estado;

    @Column(name = "Ende_cidade")
    private String Cidade;

    @Column(name = "Ende_rua")
    private String Rua;

    @Column(name = "Ende_numero")
    private String Numero;

    @Column(name = "Ende_complemento")
    private String Complemento;

    public Long getEnderecoID() {
        return EnderecoID;
    }

    public void setEnderecoID(Long enderecoID) {
        EnderecoID = enderecoID;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }
}
