package com.example.atletas.model;

public class Juvenil extends Atletas{
    private int anosPratica;

    public int getAnosPratica() {
        return anosPratica;
    }

    public void setAnosPratica(int anosPratica) {
        this.anosPratica = anosPratica;
    }

    @Override
    public String toString() {
        return "Juvenil{" +
                "nome='" + getNome() + '\'' +
                "anosPratica=" + anosPratica +
                '}';
    }
}
