package com.example.applistadecompras.model;

public class Compras {
    private String nomeDoProduto;
    private String QuantidadeDeProdutos;
    private String localParaComprar;

    public Compras() {

    }

    public Compras(String nomeDoProduto, String quantidadeDeProdutos, String localParaComprar) {
        this.nomeDoProduto = nomeDoProduto;
        QuantidadeDeProdutos = quantidadeDeProdutos;
        this.localParaComprar = localParaComprar;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public String getQuantidadeDeProdutos() {
        return QuantidadeDeProdutos;
    }

    public void setQuantidadeDeProdutos(String quantidadeDeProdutos) {
        QuantidadeDeProdutos = quantidadeDeProdutos;
    }

    public String getLocalParaComprar() {
        return localParaComprar;
    }

    public void setLocalParaComprar(String localParaComprar) {
        this.localParaComprar = localParaComprar;
    }
}
