package com.example.applistadetarefas.model;

public class Pessoa {
    private String listaDesejado;

    public Pessoa() {

    }

    public Pessoa(String listaDesejado) {
        this.listaDesejado = listaDesejado;
    }

    public String getListaDesejado() {
        return listaDesejado;
    }

    public void setListaDesejado(String listaDesejado) {
        this.listaDesejado = listaDesejado;
    }
}
