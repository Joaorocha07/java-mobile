package com.example.applistadetarefas.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.applistadetarefas.model.Tarefa;
import com.example.applistadetarefas.view.MainActivity;

public class TarefaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public TarefaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciado");
        return super.toString();
    }

    public void salvar(Tarefa novaTarefa) {
        Log.d("MVC_Controller", "Salvo" + novaTarefa.toString());
        listaVip.putString("Nome da Tarefa", novaTarefa.getNomeDaTarefa());
        listaVip.putString("Descrição", novaTarefa.getDescricao());
        listaVip.putString("Data de Conclusão", novaTarefa.getDataDeConclusao());
        listaVip.apply();
    }

    public Tarefa buscar(Tarefa novaTarefa) {
        novaTarefa.setNomeDaTarefa(preferences.getString("Nome da Tarefa", ""));
        novaTarefa.setDescricao(preferences.getString("Descrição", ""));
        novaTarefa.setDataDeConclusao(preferences.getString("Data de Conclusão", ""));
        return  novaTarefa;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }

}
