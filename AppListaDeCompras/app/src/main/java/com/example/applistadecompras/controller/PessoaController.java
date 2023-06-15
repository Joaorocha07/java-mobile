package com.example.applistadecompras.controller;

import com.example.applistadecompras.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaController {
    private List listaCompras;

    public PessoaController() {
        listaCompras = new ArrayList();
        lista();
    }

    public List<Pessoa> getListaCompras() {
        return listaCompras;
    }

    private List lista() {
        listaCompras = new ArrayList<Pessoa>();
        listaCompras.add(new Pessoa("Salgadinho"));
        listaCompras.add(new Pessoa("Finni"));
        listaCompras.add(new Pessoa("Pizza"));
        listaCompras.add(new Pessoa("Pão De Alho"));
        listaCompras.add(new Pessoa("Pão De Queijo"));
        listaCompras.add(new Pessoa("Batata Palha"));
        listaCompras.add(new Pessoa("Refrigerante"));
        listaCompras.add(new Pessoa("Chocolate"));
        return listaCompras;
    }

    public ArrayList<String> dadosSpinner() {
        ArrayList<String> dados = new ArrayList<>();
        for (int i = 0; i < getListaCompras().size(); i++) {
            Pessoa objeto = (Pessoa) getListaCompras().get(i);
            dados.add(objeto.getCompradesejado());
        }
        return dados;
    }
}
