package com.example.exemploJPA.model.entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Usu_id")
    private Long UsuarioID;

    @Column(name = "Usu_phone")
    private String UsuarioPhone;

    @ManyToOne
    @JoinColumn(name = "Ende_id")
    private Endereco Endereco;

    @Column(name = "Usu_nome")
    private String UsuarioNome;

    @Column(name = "Usu_senha")
    private String UsuarioSenha;

    @Column(name = "Usu_cpf")
    private String UsuarioCPF;

    @Column(name = "Usu_nascimento")
    @Temporal(TemporalType.DATE)
    private Date UsuarioNascimento;

    @Column(name = "Usu_email")
    private Date UsuarioEmail;

    @Column(name = "Usu_admin")
    private boolean UsuarioAdmin;

    @Column(name = "Usu_conta_ativa")
    private boolean UsuarioAtivo;

    public Long getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(Long usuarioID) {
        UsuarioID = usuarioID;
    }

    public String getUsuarioPhone() {
        return UsuarioPhone;
    }

    public void setUsuarioPhone(String usuarioPhone) {
        UsuarioPhone = usuarioPhone;
    }

    public com.example.exemploJPA.model.entities.Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(com.example.exemploJPA.model.entities.Endereco endereco) {
        Endereco = endereco;
    }

    public String getUsuarioNome() {
        return UsuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        UsuarioNome = usuarioNome;
    }

    public String getUsuarioSenha() {
        return UsuarioSenha;
    }

    public void setUsuarioSenha(String usuarioSenha) {
        UsuarioSenha = usuarioSenha;
    }

    public String getUsuarioCPF() {
        return UsuarioCPF;
    }

    public void setUsuarioCPF(String usuarioCPF) {
        UsuarioCPF = usuarioCPF;
    }

    public Date getUsuarioNascimento() {
        return UsuarioNascimento;
    }

    public void setUsuarioNascimento(Date usuarioNascimento) {
        UsuarioNascimento = usuarioNascimento;
    }

    public Date getUsuarioEmail() {
        return UsuarioEmail;
    }

    public void setUsuarioEmail(Date usuarioEmail) {
        UsuarioEmail = usuarioEmail;
    }

    public boolean isUsuarioAdmin() {
        return UsuarioAdmin;
    }

    public void setUsuarioAdmin(boolean usuarioAdmin) {
        UsuarioAdmin = usuarioAdmin;
    }

    public boolean isUsuarioAtivo() {
        return UsuarioAtivo;
    }

    public void setUsuarioAtivo(boolean usuarioAtivo) {
        UsuarioAtivo = usuarioAtivo;
    }
}
