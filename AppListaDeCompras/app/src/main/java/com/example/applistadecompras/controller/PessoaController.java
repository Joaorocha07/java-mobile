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
        listaCompras.add(new Pessoa("Informatica"));
        listaCompras.add(new Pessoa("Informatica"));
        listaCompras.add(new Pessoa("Informatica"));
        listaCompras.add(new Pessoa("Informatica"));
        listaCompras.add(new Pessoa("Informatica"));
        listaCompras.add(new Pessoa("Informatica"));
        listaCompras.add(new Pessoa("Informatica"));
        listaCompras.add(new Pessoa("Informatica"));
        return listaCompras;
    }
}
