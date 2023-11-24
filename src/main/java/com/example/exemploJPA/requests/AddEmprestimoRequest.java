package com.example.exemploJPA.requests;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddEmprestimoRequest {
    private Integer usuId;

    private Integer funcId;

    private List<Integer> exempIds;

    @JsonCreator
    public AddEmprestimoRequest(@JsonProperty("usuId") Integer usuId,
            @JsonProperty("funcId") Integer funcId,
            @JsonProperty("exempIds") List<Integer> exempIds) {
        this.usuId = usuId;
        this.funcId = funcId;
        this.exempIds = exempIds;
    }

    public Integer getFuncId() {
        return funcId;
    }

    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }

    public List<Integer> getExempIds() {
        return exempIds;
    }

    public List<Long> getLongExempIds() {
        List<Long> longList = new ArrayList<>();
        for (Integer item : this.getExempIds())
            longList.add((long) item);
        return longList;
    }

    public void setExempIds(List<Integer> exempIds) {
        this.exempIds = exempIds;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

}
