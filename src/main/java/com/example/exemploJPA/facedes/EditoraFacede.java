package com.example.exemploJPA.facedes;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exemploJPA.model.entities.Editora;
import com.example.exemploJPA.model.repositories.EditoraRepository;


@Service
public class EditoraFacede {
    @Autowired
    private EditoraRepository repository;

    public List<Editora> listarEditoras() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return Collections.emptyList();
        }

    }
}
