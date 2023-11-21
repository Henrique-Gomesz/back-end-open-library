package com.example.exemploJPA.https;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemploJPA.facedes.EditoraFacede;
import com.example.exemploJPA.model.entities.Editora;

@RestController
@RequestMapping("/editora")
public class EditoraHttps {
   
    @Autowired
    private EditoraFacede editoraFacede;

    @GetMapping()
    public ResponseEntity<Object> listarCategorias()
    {
        List<Editora> categorias = editoraFacede.listarEditoras();

        if(!categorias.isEmpty())
            return ResponseEntity.ok(categorias);
        else
            return ResponseEntity.status(500).body("Ocorreu ao resgatas as categorias");
    }
   

}
