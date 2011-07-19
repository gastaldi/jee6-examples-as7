package com.george.cdi;

import javax.enterprise.inject.Model;

@Model
public class Cliente {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
