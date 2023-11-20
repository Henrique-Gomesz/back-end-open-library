package com.example.exemploJPA.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exemploJPA.model.entities.Autor;

@Repository()
public interface AutorRepository extends JpaRepository<Autor, Long> {
}








