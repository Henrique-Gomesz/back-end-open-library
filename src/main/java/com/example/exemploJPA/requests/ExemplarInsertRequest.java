package com.example.exemploJPA.requests;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.exemploJPA.model.entities.Exemplar;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExemplarInsertRequest {

    private Long livroId;
    private String statusExemplar;
    private String exempEdicao;
    private Integer anoPublicacao;
    private Date dataExemplar;

    @JsonCreator
    public ExemplarInsertRequest(
            @JsonProperty("livroId") Long livroId, @JsonProperty("statusExemp") String statusExemp, @JsonProperty("exempEdicao") String exempEdicao, @JsonProperty("anoPublicacao") Integer anoPublicacao, @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date dataExemp) {
        this.livroId = livroId;
        this.statusExemplar = statusExemp;
        this.anoPublicacao = anoPublicacao;
        this.dataExemplar = dataExemp;
        this.exempEdicao = exempEdicao;
    }


    public Long getLivroId() {
        return this.livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public String getStatusExemplar() {
        return this.statusExemplar;
    }

    public void setStatusExemplar(String statusExemplar) {
        this.statusExemplar = statusExemplar;
    }

    public String getExempEdicao() {
        return this.exempEdicao;
    }

    public void setExempEdicao(String exempEdicao) {
        this.exempEdicao = exempEdicao;
    }

    public Integer getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Date getDataExemplar() {
        return this.dataExemplar;
    }

    public void setDataExemplar(Date dataExemplar) {
        this.dataExemplar = dataExemplar;
    }



    public Exemplar toDomain() {
        Exemplar exemplar = new Exemplar();
        
        exemplar.setAnoPublicacao(anoPublicacao);
        exemplar.setDataExemplar(dataExemplar);
        exemplar.setEdicao(exempEdicao);
        exemplar.setLivroId(livroId);
        exemplar.setStatusExemplar(statusExemplar);
        
        return exemplar;
    }
}
