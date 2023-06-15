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
        listaTarefa.add(new Pessoa("Teste"));
        listaTarefa.add(new Pessoa("Nova tarefa"));
        listaTarefa.add(new Pessoa("asdasd"));
        listaTarefa.add(new Pessoa("asdsad"));
        return listaTarefa;
    }
}
