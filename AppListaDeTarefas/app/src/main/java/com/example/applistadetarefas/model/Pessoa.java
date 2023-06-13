package com.example.applistadetarefas.model;

public class Pessoa {
    private String cursoDesejado;

    public Pessoa() {

    }

    public Pessoa(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }
}
