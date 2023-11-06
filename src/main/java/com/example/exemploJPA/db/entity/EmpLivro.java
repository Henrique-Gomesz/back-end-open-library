package com.example.exemploJPA.db.entity;

import jakarta.persistence.*;

@Entity
@Table(name="emprestimo_livro")
public class EmpLivro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="el_id")
    private Long id;
    @Column(name="el_dias")
    private int dias;
    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Emprestimo emprestimo;
    @ManyToOne
    @JoinColumn(name = "liv_id", referencedColumnName = "liv_id")
    private Livro livro;

    public EmpLivro() {
    }

    public EmpLivro(Long id, int dias) {
        this.id = id;
        this.dias = dias;
        this.emprestimo = emprestimo;
        this.livro = livro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Livro getLivro() {
        return livro;
    }
}
