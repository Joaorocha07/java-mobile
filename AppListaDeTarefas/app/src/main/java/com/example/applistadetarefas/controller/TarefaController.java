package com.example.applistadetarefas.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.applistadetarefas.model.Tarefa;

public class TarefaController {

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciado");
        return super.toString();
    }

    public void salvar(Tarefa novaTarefa) {
        Log.d("MVC_Controller", "Salvo" + novaTarefa.toString());
    }
}
