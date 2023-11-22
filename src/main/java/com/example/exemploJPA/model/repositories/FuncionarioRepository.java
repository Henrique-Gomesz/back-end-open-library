package com.example.exemploJPA.model.repositories;

import com.example.exemploJPA.model.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exemploJPA.model.entities.Livro;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}








