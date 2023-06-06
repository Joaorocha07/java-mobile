package com.example.appimc.view.model;

public class PessoaModel {
    private String altura;
    private String peso;

    public PessoaModel() {

    }

    public PessoaModel(String altura, String peso) {
        this.altura = altura;
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
}
