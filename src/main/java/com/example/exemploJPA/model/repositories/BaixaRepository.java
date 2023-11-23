package com.example.exemploJPA.model.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.exemploJPA.model.entities.Baixa;

import jakarta.transaction.Transactional;

@Repository()
public interface BaixaRepository extends JpaRepository<Baixa, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value="update baixa set exemp_id = :exempId, funci_id = :funcId, baixa_desc = :desc, baixa_data = :baixaData, baixa_motivo = :motivoBaixa where baixa_id = :id",nativeQuery = true)
    public void updateBaixa(String desc, Long id, Date baixaData, Long exempId, Long funcId, String motivoBaixa);

    @Query(value="select * from baixa where baixa_motivo = :motivoBaixa",nativeQuery = true)
    public List<Baixa> findAllByMotivo(String motivoBaixa);

    @Query(value="select * from baixa where extract(year from baixa_data) = :ano",nativeQuery = true)
    public List<Baixa> findAllByAno(Integer ano);
}

