package com.example.atletas.controller;

import com.example.atletas.model.Adulto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperacaoAdulto implements IOperacao<Adulto>{
    List<Adulto> lista;

    public OperacaoAdulto(){
        this.lista = new ArrayList<>();
    }

    @Override
    public void cadastrar(Adulto adulto) {
        lista.add(adulto);
    }

    @Override
    public List<Adulto> listar() {
        return this.lista;
    }
}
