package com.example.exemploJPA.model.repositories;

import com.example.exemploJPA.model.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.exemploJPA.model.entities.AutorLivro;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
