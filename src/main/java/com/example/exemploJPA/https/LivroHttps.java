package com.example.exemploJPA.https;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemploJPA.facedes.LivroFacede;
import com.example.exemploJPA.model.entities.Livro;
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

    @GetMapping()
    public ResponseEntity<Object> listarLivros(
            @RequestParam(required = false, defaultValue = "-1") Integer categoriaId,
            @RequestParam(required = false, defaultValue = "-1") Integer editoraId,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataPublicacao,
            @RequestParam(required = false) String nome) {

     

        List<Livro> livros = this.livroFacede.getLivros(nome, dataPublicacao, categoriaId.longValue(),
                editoraId.longValue());

        return ResponseEntity.ok(livros);

    }

}
