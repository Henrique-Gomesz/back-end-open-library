package com.example.exemploJPA.facedes;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exemploJPA.model.entities.Categoria;
import com.example.exemploJPA.model.repositories.CategoriaRepository;


@Service
public class CategoriaFacede {
    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> listarCategorias() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return Collections.emptyList();
        }

    }
}
