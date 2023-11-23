package com.example.exemploJPA.facedes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exemploJPA.model.entities.Baixa;
import com.example.exemploJPA.model.entities.Exemplar;
import com.example.exemploJPA.model.repositories.ExemplarRepository;


@Service
public class ExemplarFacede {
    @Autowired
    private ExemplarRepository repository;

    public boolean inserirExemplar(Exemplar exemplar) {
        try {
            repository.save(exemplar);
            return true;
        } catch (Exception e) {
           
            return false;
        }
    }

        public Exemplar consultarExemplar(Long id) {
        try {
            return repository.findById(id).get();
        } catch (Exception e) {
           System.out.println("Ocorreu um erro ao consultar o exemplar no SQL!");
           Exemplar nulla = new Exemplar();
           return nulla;
        }
    }

        public boolean excluirExemplarId(Long id) {
        try {

            Exemplar consulta = repository.findById(id).get();

            
            if(consulta.getId() != null){
                repository.deleteExemplar("INATIVO", id);
                return true;
            }

            throw new IOException();
            
        } catch (Exception e) {
           System.out.println("Ocorreu um erro ao excluir o exemplar no SQL!");
           return false;
        }
    }

        public boolean atualizarExemplarId(Exemplar exemp) {
        try {

            Exemplar consulta = repository.findById(exemp.getId()).get();

            
            if(consulta.getId() != null){
                if(exemp.getId() == null || exemp.getLivroId() == null ||  exemp.getStatusExemplar() == null || exemp.getDataExemplar() == null || exemp.getEdicao() == null || exemp.getAnoPublicacao() == null){
                    throw new IOException();
                }
                repository.updateExemplar(exemp.getId(), exemp.getLivroId(),  exemp.getStatusExemplar(), exemp.getDataExemplar(), exemp.getEdicao(), exemp.getAnoPublicacao());
                return true;
            }

            throw new IOException();
            
        } catch (Exception e) {
           System.out.println("Ocorreu um erro ao atualizar o exemplar no SQL!");
           return false;
        }
    }

    public List<Exemplar> consultaExemplarStatus(String status) {
        try {
            List<Exemplar> exemplarInfo = repository.findAllByStatus(status);
            return exemplarInfo;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao consultar os exemplares no SQL!");
            List<Exemplar> nulla = new ArrayList<Exemplar>();
            return nulla;
        }
    }

        public List<Exemplar> consultaExemplarAno(Integer ano) {
        try {
            List<Exemplar> exemplarInfo = repository.findAllByAno(ano);
            return exemplarInfo;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao consultar os exemplares no SQL!");
            List<Exemplar> nulla = new ArrayList<Exemplar>();
            return nulla;
        }
    }

}
