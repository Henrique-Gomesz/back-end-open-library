package com.example.exemploJPA.facedes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exemploJPA.model.entities.AutorLivro;
import com.example.exemploJPA.model.entities.Livro;
import com.example.exemploJPA.model.repositories.AutorLivroRepository;
import com.example.exemploJPA.model.repositories.LivroRepository;
import com.example.exemploJPA.requests.AddLivroRequest;

@Service
public class LivroFacede {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorLivroRepository autoresLivrosRepository;

    public boolean inserirLivro(AddLivroRequest request) {
        try {
            Livro livroSalvo = livroRepository.save(livro);
            autoresIds.forEach((autor) -> insertAutorLivros(autor, livroSalvo.getLivroId()));
            return true;
        } catch (Exception e) {

            return false;
        }

    }

    private void insertAutorLivros(Number autorId, Long livroId) {
        AutorLivro autorLivro = new AutorLivro();
        autorLivro.setAutorId(autorId.longValue());
        autorLivro.setLivroId(livroId);

        autoresLivrosRepository.save(autorLivro);

    }
}
