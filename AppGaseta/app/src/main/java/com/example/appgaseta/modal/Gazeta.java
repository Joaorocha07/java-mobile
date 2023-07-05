package com.example.appgaseta.modal;

public class Gazeta {
    private String gasolina;
    private String etanol;

    public Gazeta() {

    }

    public Gazeta(String gasolina, String etanol) {
        this.gasolina = gasolina;
        this.etanol = etanol;
    }

    public String getGasolina() {
        return gasolina;
    }

    public void setGasolina(String gasolina) {
        this.gasolina = gasolina;
    }

    public String getEtanol() {
        return etanol;
    }

    public void setEtanol(String etanol) {
        this.etanol = etanol;
    }
}
