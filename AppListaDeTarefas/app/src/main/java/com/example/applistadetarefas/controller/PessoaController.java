package com.example.applistadetarefas.controller;

import com.example.applistadetarefas.model.Pessoa;
import com.example.applistadetarefas.model.Tarefa;

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
        listaTarefa = new ArrayList<Tarefa>();
        listaTarefa.add(new Tarefa("Teste"));
        listaTarefa.add(new Tarefa("Nova tarefa"));
        listaTarefa.add(new Tarefa("asdasd"));
        listaTarefa.add(new Tarefa("asdsad"));
        return listaTarefa;
    }
}
