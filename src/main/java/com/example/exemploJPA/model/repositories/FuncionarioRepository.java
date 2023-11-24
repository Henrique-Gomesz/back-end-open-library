package com.example.exemploJPA.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.exemploJPA.model.entities.Funcionario;

@Repository()
@EnableJpaRepositories
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
