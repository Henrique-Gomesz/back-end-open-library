package com.example.exemploJPA.model.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.exemploJPA.model.entities.Exemplar;

import jakarta.transaction.Transactional;

@Repository()
public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value="update exemplar set exemp_status = :newStatus where exemp_id = :id",nativeQuery = true)
    public void deleteExemplar(String newStatus, Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value="update exemplar set livro_id = :livroId, exemp_status = :newStatus, exemp_data = :newDate, exemp_edicao = :edicao, exemp_anopubli = :anoPubli where exemp_id = :id",nativeQuery = true)
    public void updateExemplar(Long id, Long livroId, String newStatus, Date newDate, String edicao, Integer anoPubli);

    @Query(value="select * from exemplar where exemp_status = :statusExemplar",nativeQuery = true)
    public List<Exemplar> findAllByStatus(String statusExemplar);

        @Query(value="select * from exemplar where exemp_anopubli = :ano",nativeQuery = true)
    public List<Exemplar> findAllByAno(Integer ano);
}
