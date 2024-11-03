package com.example.atletas.controller;

import com.example.atletas.model.Juvenil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperacaoJuvenil implements  IOperacao<Juvenil> {
    List<Juvenil> lista;

    public OperacaoJuvenil(){
        this.lista = new ArrayList<>();
    }
    @Override
    public void cadastrar(Juvenil juvenil) {
        lista.add(juvenil);
    }

    @Override
    public List<Juvenil> listar() {
        return this.lista;
    }
}
