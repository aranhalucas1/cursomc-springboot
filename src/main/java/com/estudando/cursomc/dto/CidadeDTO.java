package com.estudando.cursomc.dto;

import com.estudando.cursomc.domain.Cidade;
import com.estudando.cursomc.domain.Estado;

import java.io.Serializable;

public class CidadeDTO implements Serializable {

    private Integer id;
    private String nome;

    public CidadeDTO() {
    }

    public CidadeDTO(Cidade obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
