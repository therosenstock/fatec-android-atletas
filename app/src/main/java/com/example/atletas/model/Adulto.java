package com.example.atletas.model;

public class Adulto extends Atletas{
    private String academia;
    private double recorde;

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public double getRecorde() {
        return recorde;
    }

    public void setRecorde(double recorde) {
        this.recorde = recorde;
    }

    @Override
    public String toString() {
        return "Adulto{" +
                "nome='" + getNome() + '\'' +
                "academia='" + academia + '\'' +
                ", recorde=" + recorde +
                '}';
    }
}
