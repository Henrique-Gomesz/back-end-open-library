package com.example.exemploJPA.model.entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Res_id")
    private Long ReservaID;

    @OneToOne
    @JoinColumn(name = "Funci_id", referencedColumnName = "Funci_id")
    private Funcionario funcionario;

    @OneToOne
    @JoinColumn(name = "Usu_id", referencedColumnName = "Usu_id")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "Livro_id", referencedColumnName = "Livro_id")
    private Livro livro;

    @Column(name = "Res_data")
    private Date DataReserva;

    public Long getReservaID() {
        return ReservaID;
    }

    public void setReservaID(Long reservaID) {
        ReservaID = reservaID;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Date getDataReserva() {
        return DataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        DataReserva = dataReserva;
    }
}
