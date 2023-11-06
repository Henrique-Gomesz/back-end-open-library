package com.example.exemploJPA.db.repository;

import com.example.exemploJPA.db.entity.Emprestimo;
import com.example.exemploJPA.db.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository  extends JpaRepository<Emprestimo, Long> {
}
