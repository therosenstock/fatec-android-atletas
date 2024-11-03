package com.example.atletas.model;

import androidx.annotation.NonNull;

import java.time.LocalDate;
import java.util.Date;

public abstract class Atletas {
    private String nome;
    private Date nascimento;
    private String bairro;

    public Atletas(){
        super();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NonNull
    @Override
    public String toString() {
        return "Atletas{" +
                "nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
