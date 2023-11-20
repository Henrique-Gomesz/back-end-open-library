package com.example.exemploJPA.https;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemploJPA.facedes.AutorFacede;
import com.example.exemploJPA.model.entities.Autor;

@RestController
@RequestMapping("/autor")
public class AutorHttps {
   
    private final AutorFacede autorFacede = AutorFacede.getInstance();

    @PostMapping("/")
    public ResponseEntity<Object> inserirAutor(@RequestBody Autor autor)
    {
        boolean status = autorFacede.inserirAutor(autor);

        if(status)
            return ResponseEntity.ok("Autor inserido com sucesso!");
        else
            return ResponseEntity.status(500).body("Ocorreu um erro ao inserir o autor");
    }
   

}
