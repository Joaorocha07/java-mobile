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
    private TarefasDB tarefasDB;

    public TarefaController(Context context) {
        tarefasDB = new TarefasDB(context);
    }


    public void salvar(Tarefa tarefa) {
        SQLiteDatabase db = tarefasDB.getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("Tarefa", tarefa.getNomeDaTarefa());
        dados.put("Descricao", tarefa.getDescricao());
        dados.put("Conclusao", tarefa.getDataDeConclusao());

        db.insert("Tarefas", null, dados);
        db.close();
    }
}
