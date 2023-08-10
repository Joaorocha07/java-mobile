package com.example.appagenda.controller;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.appagenda.database.AgendaDB;
import com.example.appagenda.model.Agenda;
import com.example.appagenda.model.Pessoa;
import com.example.appagenda.view.MainActivity;

public class AgendaController {
    private AgendaDB agendaDB;

    public AgendaController(Context context) {
        agendaDB = new AgendaDB(context);
    }

    public void salvar(Agenda agenda) {
        SQLiteDatabase db = agendaDB.getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("Titulo", agenda.getTitulo());
        dados.put("Horario", agenda.getHorario());
        dados.put("Local", agenda.getLocal());

        db.insert("Agenda", null, dados);
        db.close();
    }
}
