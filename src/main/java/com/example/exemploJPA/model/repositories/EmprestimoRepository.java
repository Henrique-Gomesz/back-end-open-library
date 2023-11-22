package com.example.exemploJPA.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.exemploJPA.model.entities.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>, JpaSpecificationExecutor<Emprestimo> {
}
