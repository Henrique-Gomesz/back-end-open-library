package com.example.exemploJPA.facedes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exemploJPA.model.entities.Autor;
import com.example.exemploJPA.model.repositories.AutorRepository;


@Service
public class AutorFacede {
    @Autowired
    private AutorRepository repository;

    public boolean inserirAutor(Autor autor) {
        try {
            repository.save(autor);
            return true;
        } catch (Exception e) {
           
            return false;
        }

    }
}
