package com.example.applistadecomprasversaodois.modal;

public class Compras {
    private String nome;
    private String quantidade;
    private int id;

    public Compras() {

    }

    public Compras(String nome, String quantidade, int id) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
