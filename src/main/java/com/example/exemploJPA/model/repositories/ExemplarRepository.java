package com.example.exemploJPA.model.repositories;

import com.example.exemploJPA.model.entities.Exemplar;
import com.example.exemploJPA.model.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.exemploJPA.model.entities.AutorLivro;

import java.util.Optional;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {

    @Query(value = "SELECT * FROM exemplar WHERE livro_id = :livro_id AND exemp_status = :status LIMIT 1",nativeQuery = true)
    public Optional<Exemplar> findDisponivelReserva(Long livro_id, String status);
}
