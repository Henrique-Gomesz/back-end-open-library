package com.example.exemploJPA.db.repository;

import com.example.exemploJPA.db.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    public List<Livro> findAllByTitulo(String titulo);

    @Query(value="select * from livro where upper(liv_titulo) like %:chave%",nativeQuery = true)
    public List<Livro> findByChave(String chave);
}








