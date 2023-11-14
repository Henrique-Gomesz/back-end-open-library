package com.example.exemploJPA.model.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Livro_id")
    private Long livroId;

    @Column(name = "Livro_nome")
    private String livroNome;

    @Column(name = "Editora_id")
    private Long editoraId;

    @Column(name = "Lanca_ano")
    private LocalDate lancaAno;

    @Enumerated(EnumType.STRING)
    @Column(name = "Genero")
    private EnumCategorias genero;

    @ManyToOne
    @JoinColumn(name = "Editora_id", referencedColumnName = "Editora_id", insertable = false, updatable = false)
    private Editora editora;

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public String getLivroNome() {
        return livroNome;
    }

    public void setLivroNome(String livroNome) {
        this.livroNome = livroNome;
    }

    public Long getEditoraId() {
        return editoraId;
    }

    public void setEditoraId(Long editoraId) {
        this.editoraId = editoraId;
    }

    public LocalDate getLancaAno() {
        return lancaAno;
    }

    public void setLancaAno(LocalDate lancaAno) {
        this.lancaAno = lancaAno;
    }

    public EnumCategorias getGenero() {
        return genero;
    }

    public void setGenero(EnumCategorias genero) {
        this.genero = genero;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    
}
