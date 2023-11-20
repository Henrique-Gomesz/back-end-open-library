package com.example.exemploJPA.facedes;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.exemploJPA.model.entities.Autor;
import com.example.exemploJPA.model.repositories.AutorRepository;

public class AutorFacede {
    private static AutorFacede instance;

    @Autowired
    private AutorRepository repository;

    private AutorFacede() {
    }

    public static AutorFacede getInstance() {
        if (instance == null) {
            instance = new AutorFacede();
        }
        return instance;
    }

    public boolean inserirAutor(Autor autor) {
        try {
            repository.save(autor);
            return true;
        } catch (Exception e) {
           
            return false;
        }

    }
}
