package com.example.exemploJPA.model.entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Funci_id")
    private Long FuncionarioID;

    @OneToOne
    @JoinColumn(name = "Usu_id", referencedColumnName = "Usu_id")
    private Usuarios UsuID;

    @Column(name = "Funci_cargo")
    private String Cargo;

    @Column(name = "Funci_dataADM")
    private Date Admissao;

    @Column(name = "Funci_dataDEM")
    private Date Demissao;

    public Long getFuncionarioID() {
        return FuncionarioID;
    }

    public void setFuncionarioID(Long funcionarioID) {
        FuncionarioID = funcionarioID;
    }

    public Usuarios getUsuID() {
        return UsuID;
    }

    public void setUsuID(Usuarios usuID) {
        UsuID = usuID;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public Date getAdmissao() {
        return Admissao;
    }

    public void setAdmissao(Date admissao) {
        Admissao = admissao;
    }

    public Date getDemissao() {
        return Demissao;
    }

    public void setDemissao(Date demissao) {
        Demissao = demissao;
    }
}
