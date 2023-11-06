package com.example.exemploJPA.db.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="emprestimo")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private Long id;
    @Column(name="emp_data")
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name="cli_id", nullable=false)
    private Cliente cliente;
    @Column(name="emp_status")
    private boolean status;

    @OneToMany(mappedBy = "emprestimo")
    private List<EmpLivro> livros;

    public Emprestimo() {
    }

    public Emprestimo(Long id, LocalDate data, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<EmpLivro> getLivros() {
        return livros;
    }

    public void setLivros(List<EmpLivro> livros) {
        this.livros = livros;
    }
}
