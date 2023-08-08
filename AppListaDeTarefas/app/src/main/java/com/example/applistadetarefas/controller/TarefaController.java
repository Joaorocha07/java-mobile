package com.example.applistadetarefas.controller;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.applistadetarefas.database.TarefasDB;
import com.example.applistadetarefas.model.Tarefa;
import com.example.applistadetarefas.view.MainActivity;

public class TarefaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    private TarefasDB tarefasDB;

    public TarefaController(Context context) {
        tarefasDB = new TarefasDB(context);
        // preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        // listaVip = preferences.edit();
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

        SQLiteDatabase db = tarefasDB.getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("Tarefa", novaTarefa.getNomeDaTarefa());
        dados.put("Descricao", novaTarefa.getDescricao());
        dados.put("Conclusao", novaTarefa.getDataDeConclusao());

        db.insert("Tarefas", null, dados);
        db.close();
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
