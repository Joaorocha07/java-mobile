package com.example.applistadetarefas.controller;

import com.example.applistadetarefas.model.Pessoa;


import java.util.ArrayList;
import java.util.List;

public class PessoaController {
    private List listaTarefa;

    public PessoaController() {
        listaTarefa = new ArrayList<>();
        lista();
    }

    public List<Pessoa> getListaCursos() {
        return listaTarefa;
    }

    private List lista() {
        listaTarefa = new ArrayList<Pessoa>();
        listaTarefa.add(new Pessoa("TCC"));
        listaTarefa.add(new Pessoa("Eventos"));
        listaTarefa.add(new Pessoa("Artes"));
        listaTarefa.add(new Pessoa("Trabalho"));
        listaTarefa.add(new Pessoa("Seminario"));
        listaTarefa.add(new Pessoa("Experimento"));
        listaTarefa.add(new Pessoa("Correio Elegante"));
        return listaTarefa;
    }

    public ArrayList<String> dadosSpinner() {
        ArrayList<String> dados = new ArrayList<>();
        for (int i = 0; i < getListaCursos().size(); i++) {
            Pessoa objeto = (Pessoa) getListaCursos().get(i);
            dados.add(objeto.getListaDesejado());
        }
        return dados;
    }
}
