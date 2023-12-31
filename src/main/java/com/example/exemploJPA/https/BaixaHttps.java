package com.example.exemploJPA.https;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemploJPA.facedes.BaixaFacede;
import com.example.exemploJPA.model.entities.Baixa;
import com.example.exemploJPA.requests.BaixaAnoRequest;
import com.example.exemploJPA.requests.BaixaGetRequest;
import com.example.exemploJPA.requests.BaixaInsertRequest;
import com.example.exemploJPA.requests.BaixaMotivoRequest;
import com.example.exemploJPA.requests.BaixaPutRequest;
import com.example.exemploJPA.requests.ExemplarPostRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter; 
@RestController
@RequestMapping("/baixa")
public class BaixaHttps {
   
    @Autowired
    private BaixaFacede baixaFacede;

    @PostMapping("realizar-baixa")
    public ResponseEntity<Object> inserirBaixa(@RequestBody BaixaInsertRequest baixa )
    {
        
        boolean status = baixaFacede.realizarBaixa(baixa.toDomain());

        if(status)
            return ResponseEntity.ok("Baixa realizada com sucesso!");
        else
            return ResponseEntity.status(500).body("Ocorreu um erro ao realizar a baixa!");
    }
   
    @GetMapping("resgatar-baixa-id")
    public ResponseEntity<Object> resgatarBaixa(@RequestParam("baixaId") Long baixa)
    {

        try{

        Baixa baixaInf = baixaFacede.consultaBaixaId(baixa);
        
        if(baixaInf.getBaixaId() != null){
        return ResponseEntity.ok(baixaInf);
        }

        return ResponseEntity.status(404).body("Não foi possível encontrar a baixa, verifique o Id e tente novamente.");

        }catch(Exception e){

            System.out.println(e);
            return ResponseEntity.status(500).body("Ocorreu um erro ao resgatar a baixa!");

        }
    }

    @PutMapping("atualizar-baixa-id")
    public ResponseEntity<Object> atualizarBaixa(@RequestBody BaixaPutRequest baixa)
    {
        
         boolean status = baixaFacede.atualizarBaixaId(baixa.toDomain());

        if(status)
            return ResponseEntity.ok("Baixa atualizada com sucesso!");
        else
            return ResponseEntity.status(500).body("Ocorreu um erro ao atualizar a baixa!");
    }


    @GetMapping("resgatar-baixa-motivo")
    public ResponseEntity<Object> consultaMotivoBaixa(@RequestParam("motivoBaixa") String motivo)
    {
        
        try{

        List<Baixa> baixaInf = baixaFacede.consultaBaixaMotivo(motivo);
        
        if(!baixaInf.isEmpty()){
        return ResponseEntity.ok(baixaInf);
        }

        return ResponseEntity.status(404).body("Não existem baixas com o motivo informado.");

        }catch(Exception e){

            System.out.println(e);
            return ResponseEntity.status(500).body("Ocorreu um erro ao resgatar as baixas!");

        }

    }

    @GetMapping("resgatar-baixa-ano")
    public ResponseEntity<Object> consultaAnoBaixa(@RequestParam("anoBaixa") Integer ano)
    {
        System.out.println(ano);
        try{
        List<Baixa> baixaInf = baixaFacede.consultaBaixaAno(ano);
        
        if(!baixaInf.isEmpty()){
        return ResponseEntity.ok(baixaInf);
        }

        return ResponseEntity.status(404).body("Não existem baixas registradas no ano informado.");

        }catch(Exception e){

            System.out.println(e);
            return ResponseEntity.status(500).body("Ocorreu um erro ao resgatar as baixas!");

        }

    }

}
