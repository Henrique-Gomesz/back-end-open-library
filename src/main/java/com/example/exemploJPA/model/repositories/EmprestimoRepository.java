package com.example.exemploJPA.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exemploJPA.model.entities.Emprestimo;
import com.example.exemploJPA.model.entities.Livro;

public interface EmprestimoRepository  extends JpaRepository<Emprestimo, Long> {
}
