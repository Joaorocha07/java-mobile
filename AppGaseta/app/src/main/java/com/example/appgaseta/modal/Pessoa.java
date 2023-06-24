package com.example.appgaseta.modal;

public class Pessoa {
    private String valorDaGasolina;
    private String valorDoEtanol;

    public Pessoa() {
    }

    public Pessoa(String valorDaGasolina, String valorDoEtanol) {
        this.valorDaGasolina = valorDaGasolina;
        this.valorDoEtanol = valorDoEtanol;
    }

    public String getValorDaGasolina() {
        return valorDaGasolina;
    }

    public void setValorDaGasolina(String valorDaGasolina) {
        this.valorDaGasolina = valorDaGasolina;
    }

    public String getValorDoEtanol() {
        return valorDoEtanol;
    }

    public void setValorDoEtanol(String valorDoEtanol) {
        this.valorDoEtanol = valorDoEtanol;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "valorDaGasolina='" + valorDaGasolina + '\'' +
                ", valorDoEtanol='" + valorDoEtanol + '\'' +
                '}';
    }
}
