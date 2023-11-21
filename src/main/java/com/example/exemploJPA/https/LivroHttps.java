package com.example.exemploJPA.https;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemploJPA.facedes.LivroFacede;
import com.example.exemploJPA.requests.AddLivroRequest;

@RestController
@RequestMapping("/livro")
public class LivroHttps {
    @Autowired
    private LivroFacede livroFacede;

    @PostMapping()
    public ResponseEntity<Object> inserirAutor(@RequestBody AddLivroRequest body) {

        boolean status = livroFacede.inserirLivro(body);
        if (status)
            return ResponseEntity.ok("Livro inserido com sucesso");
        else
            return ResponseEntity.status(400).body("Falha ao inserir Livro.");
    }

}
