package com.example.atletas.controller;

import com.example.atletas.model.Senior;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperacaoSenior implements IOperacao<Senior> {
    List<Senior> lista;

    public OperacaoSenior(){
        this.lista = new ArrayList<>();
    }
    @Override
    public void cadastrar(Senior senior) {
        lista.add(senior);
    }

    @Override
    public List<Senior> listar() {
        return this.lista;
    }
}
