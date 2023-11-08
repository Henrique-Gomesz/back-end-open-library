package com.example.exemploJPA.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.exemploJPA.model.entities.Livro;
import com.example.exemploJPA.model.repositories.LivroRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/livro")
public class Livrocontroller {
    @Autowired
    private LivroRepository repo;
    @GetMapping("buscar_todos")
    public ResponseEntity<Object> buscarTodos()
    {
        return ResponseEntity.ok(repo.findAll());
    }
    @GetMapping("buscar_id/{id}")
    public ResponseEntity<Object> buscarTodos(@PathVariable("id") Long id)
    {
        Optional<Livro> olivro=repo.findById(id);
        if(olivro.isEmpty())
            return ResponseEntity.badRequest().body("livro não encontrado");
        else
            return ResponseEntity.ok(olivro.get());
    }
    @GetMapping("buscar_titulo/{titulo}")
    public ResponseEntity<Object> buscarTitulo(@PathVariable("titulo") String titulo)
    {
        return ResponseEntity.ok(repo.findAllByTitulo(titulo));
    }
    @GetMapping("buscar_chave/{chave}")
    public ResponseEntity<Object> buscarChave(@PathVariable("chave") String chave)
    {
        return ResponseEntity.ok(repo.findByChave(chave));
    }
    @PostMapping("incluir")
    public ResponseEntity<Object> incluir(@RequestBody Livro livro)
    {
        return ResponseEntity.ok(repo.save(livro));
    }
    @PostMapping("alterar")
    public ResponseEntity<Object> alterar(@RequestBody Livro livro)
    {
        return ResponseEntity.ok(repo.save(livro));
    }
    @GetMapping("apagar/{id}")
    public void apagar(@PathVariable Long id)
    {
        repo.deleteById(id);
    }

}
