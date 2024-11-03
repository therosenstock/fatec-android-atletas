package com.example.atletas.model;

public class Senior extends Atletas{
    private boolean cardiaco;

    public boolean isCardiaco() {
        return cardiaco;
    }

    public void setCardiaco(boolean cardiaco) {
        this.cardiaco = cardiaco;
    }

    @Override
    public String toString() {
        return "Senior{" +
                "nome='" + getNome() + '\'' +
                "cardiaco=" + cardiaco +
                '}';
    }
}
