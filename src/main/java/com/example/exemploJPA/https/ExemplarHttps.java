package com.example.exemploJPA.https;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemploJPA.facedes.ExemplarFacede;
import com.example.exemploJPA.model.entities.Baixa;
import com.example.exemploJPA.model.entities.Exemplar;
import com.example.exemploJPA.requests.BaixaGetRequest;
import com.example.exemploJPA.requests.BaixaMotivoRequest;
import com.example.exemploJPA.requests.ExemplarAnoRequest;
import com.example.exemploJPA.requests.ExemplarGetDeleteRequest;
import com.example.exemploJPA.requests.ExemplarInsertRequest;
import com.example.exemploJPA.requests.ExemplarPostRequest;
import com.example.exemploJPA.requests.ExemplarStatusRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
@RequestMapping("/exemplar")
public class ExemplarHttps {
   
    @Autowired
    private ExemplarFacede exemplarFacede;

    @PostMapping("registrar-exemplar")
    public ResponseEntity<Object> inserirExemplar(@RequestBody ExemplarInsertRequest exemplar)
    {
        
        boolean status = exemplarFacede.inserirExemplar(exemplar.toDomain());

        if(status)
            return ResponseEntity.ok("Exemplar registrado com sucesso!");
        else
            return ResponseEntity.status(500).body("Ocorreu um erro ao registrar o exemplar!");
    }

    @GetMapping("resgatar-exemplar-id")
    public ResponseEntity<Object> resgatarExemplar(@RequestParam("exempId") Long exemp)
    {

        try{

        Exemplar exempInf = exemplarFacede.consultarExemplar(exemp);
        
        if(exempInf.getId() != null){
        return ResponseEntity.ok(exempInf);
        }

        return ResponseEntity.status(404).body("Não foi possível encontrar o exemplar, verifique o Id e tente novamente.");

        }catch(Exception e){

            System.out.println(e);
            return ResponseEntity.status(500).body("Ocorreu um erro ao resgatar o exemplar!");

        }
    }

    @DeleteMapping("deletar-exemplar-id")
    public ResponseEntity<String> deletarExemplar(@RequestBody ExemplarGetDeleteRequest exemp )
    {

        try{

        boolean exempBoolean = exemplarFacede.excluirExemplarId(exemp.toDomain());
        
        if(exempBoolean){
        return ResponseEntity.ok("Exemplar "+exemp.toDomain()+" foi exluido com sucesso!");
        }

        return ResponseEntity.status(404).body("Não foi possível encontrar o exemplar, verifique o Id e tente novamente.");

        }catch(Exception e){

            System.out.println(e);
            return ResponseEntity.status(500).body("Ocorreu um erro ao deletar o exemplar!");

        }
    }

    @PutMapping("atualizar-exemplar-id")
    public ResponseEntity<Object> atualizarExemplar(@RequestBody ExemplarPostRequest exemplar)
    {
        
         boolean status = exemplarFacede.atualizarExemplarId(exemplar.toDomain());

        if(status)
            return ResponseEntity.ok("Exemplar atualizado com sucesso!");
        else
            return ResponseEntity.status(500).body("Ocorreu um erro ao atualizar o exemplar!");
    }

    @GetMapping("resgatar-exemplar-status")
    public ResponseEntity<Object> consultaStatusExemplar(@RequestParam("status") String status)
    {
        
        try{


        List<Exemplar> exempInfo = exemplarFacede.consultaExemplarStatus(status);
        
        if(!exempInfo.isEmpty()){
        return ResponseEntity.ok(exempInfo);
        }

        return ResponseEntity.status(404).body("Não existem exemplares com o status informado.");

        }catch(Exception e){

            System.out.println(e);
            return ResponseEntity.status(500).body("Ocorreu um erro ao resgatar os exemplares!");

        }

    }

    @GetMapping("resgatar-exemplar-ano")
    public ResponseEntity<Object> consultaAnoExemplar(@RequestParam("ano") Integer ano)
    {
        
        try{
        List<Exemplar> exempInfo = exemplarFacede.consultaExemplarAno(ano);
        
        if(!exempInfo.isEmpty()){
        return ResponseEntity.ok(exempInfo);
        }

        return ResponseEntity.status(404).body("Não existem exemplares registrados no ano informado.");

        }catch(Exception e){

            System.out.println(e);
            return ResponseEntity.status(500).body("Ocorreu um erro ao resgatar os exemplares!");

        }

    }

}
