package com.example.exemploJPA.facedes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exemploJPA.model.entities.Baixa;
import com.example.exemploJPA.model.entities.Exemplar;
import com.example.exemploJPA.model.repositories.BaixaRepository;
import com.example.exemploJPA.model.repositories.ExemplarRepository;


@Service
public class BaixaFacede {
    @Autowired
    private BaixaRepository repository;
    private ExemplarRepository ExRepository;

    public boolean realizarBaixa(Baixa baixa) {
        try {
            ExRepository.deleteExemplar("INATIVO", baixa.getExempId());
            repository.save(baixa);
            return true;
        } catch (Exception e) {
           
            return false;
        }
    }

        public Baixa consultaBaixaId(Long baixaId) {
        try {
            Baixa baixainfo = repository.findById(baixaId).get();
            return baixainfo;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao consultar a baixa no SQL!");
            Baixa nulla = new Baixa();
            return nulla;
        }
    }

            public boolean atualizarBaixaId(Baixa baixa) {
        try {

            Baixa consulta = repository.findById(baixa.getBaixaId()).get();

            
            if(consulta.getBaixaId() != null){
                if(baixa.getBaixaDesc() == null || baixa.getBaixaId() == null || baixa.getDataBaixa() == null || baixa.getExempId() == null || baixa.getFunciId() == null || baixa.getMotivoBaixa() == null){
                    throw new IOException();
                }
                repository.updateBaixa(baixa.getBaixaDesc(), baixa.getBaixaId(), baixa.getDataBaixa(), baixa.getExempId(), baixa.getFunciId(),baixa.getMotivoBaixa());
                return true;
            }

            throw new IOException();
            
        } catch (Exception e) {
           System.out.println("Ocorreu um erro ao atualizar o exemplar no SQL!");
           return false;
        }
    }

        public List<Baixa> consultaBaixaMotivo(String motivo) {
        try {
            List<Baixa> baixainfo = repository.findAllByMotivo(motivo);
            return baixainfo;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao consultar a baixa no SQL!");
            List<Baixa> nulla = new ArrayList<Baixa>();
            return nulla;
        }
    }

        public List<Baixa> consultaBaixaAno(Integer ano) {
        try {
            List<Baixa> baixainfo = repository.findAllByAno(ano);
            return baixainfo;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao consultar a baixa no SQL!");
            List<Baixa> nulla = new ArrayList<Baixa>();
            return nulla;
        }
    }
}   