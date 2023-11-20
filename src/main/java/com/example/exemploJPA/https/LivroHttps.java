package com.example.exemploJPA.https;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemploJPA.model.entities.Autor;
import com.example.exemploJPA.model.repositories.AutorRepository;

@RestController
@RequestMapping("/livro")
public class LivroHttps {
    @Autowired
    private AutorRepository repo;
    @GetMapping("inserir-autor")
    public ResponseEntity<Object> inserirAutor()
    {
        Autor autor = new Autor();

       autor.setAutorNome("Testando");
      
        return ResponseEntity.ok(repo.save(autor));
    }
   

}
