package com.example.exemploJPA.https;

import java.util.ArrayList;
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

import com.example.exemploJPA.facedes.EmprestimoFacede;
import com.example.exemploJPA.model.entities.Emprestimo;
import com.example.exemploJPA.model.entities.Livro;
import com.example.exemploJPA.requests.AddEmprestimoRequest;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoHttps {

    @Autowired
    private EmprestimoFacede emprestimoFacede;

    @PostMapping()
    public ResponseEntity<Object> efetuarEmprestimo(@RequestBody AddEmprestimoRequest body) {

        boolean status = emprestimoFacede.efetuarEmprestimo((long) body.getUsuId(), (long) body.getFuncId(),
                body.getLongExempIds(), new Date());

        if (status)
            return ResponseEntity.ok("Autor inserido com sucesso!");
        else
            return ResponseEntity.status(500).body("Ocorreu um erro ao inserir o autor");
    }

     @GetMapping()
    public ResponseEntity<Object> listarEmprestimos(
            @RequestParam(required = false, defaultValue = "-1") Integer usuId,
            @RequestParam(required = false, defaultValue = "-1") Integer funcId,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataEmp,
            @RequestParam(required = false) String status) {

     

        List<Emprestimo> livros = this.emprestimoFacede.getEmprestimos(usuId.longValue(), funcId.longValue(), dataEmp, status);

        return ResponseEntity.ok(livros);

    }

}
