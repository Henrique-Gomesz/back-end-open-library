package com.example.exemploJPA.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemploJPA.model.entities.Emprestimo;
import com.example.exemploJPA.model.entities.Livro;
import com.example.exemploJPA.model.repositories.EmprestimoRepository;
import com.example.exemploJPA.model.repositories.LivroRepository;

import java.util.Optional;


@RestController
@RequestMapping("/api/emprestimo")
public class EmprestimoController {
    @Autowired
    private EmprestimoRepository repo;
    @GetMapping("buscar_id/{id}")
    public ResponseEntity<Object> buscarTodos(@PathVariable("id") Long id)
    {
        Optional<Emprestimo> oemprestimo=repo.findById(id);
        if(oemprestimo.isEmpty())
            return ResponseEntity.badRequest().body("emprestimo não encontrado");
        else
            return ResponseEntity.ok(oemprestimo.get());
    }
}
