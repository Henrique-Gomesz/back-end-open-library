package com.example.exemploJPA.https;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemploJPA.facedes.CategoriaFacede;
import com.example.exemploJPA.model.entities.Categoria;

@RestController
@RequestMapping("/categoria")
public class CategoriaHttps {
   
    @Autowired
    private CategoriaFacede categoriaFaface;

    @GetMapping()
    public ResponseEntity<Object> listarCategorias()
    {
        List<Categoria> categorias = categoriaFaface.listarCategorias();

        if(!categorias.isEmpty())
            return ResponseEntity.ok(categorias);
        else
            return ResponseEntity.status(500).body("Ocorreu ao resgatas as categorias");
    }
   

}
