package com.example.exemploJPA.model.repositories;

import com.example.exemploJPA.model.entities.Reserva;
import com.example.exemploJPA.model.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.exemploJPA.model.entities.AutorLivro;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

    @Query (value = "SELECT * FROM Usuarios WHERE Usu_cpf = :cpf", nativeQuery = true)
    public Optional<Usuarios> findByCpf(String cpf);
}
