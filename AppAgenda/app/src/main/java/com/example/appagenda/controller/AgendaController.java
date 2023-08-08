package com.example.appagenda.controller;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.appagenda.database.AgendaDB;
import com.example.appagenda.model.Agenda;
import com.example.appagenda.view.MainActivity;

public class AgendaController {

    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    private AgendaDB agendaDB;

    public AgendaController(Context context) {
        agendaDB = new AgendaDB(context);
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "toString: ");
        return super.toString();
    }

//    public Agenda salvar(Agenda novaAgenda) {
//        Log.d("MVC_Controller", "salvo" + novaAgenda.toString());
//        listaVip.putString("Titulo", novaAgenda.getTitulo());
//        listaVip.putString("Horario", novaAgenda.getHorario());
//        listaVip.putString("Local", novaAgenda.getLocal());
//        listaVip.apply();
//        return novaAgenda;
//    }

    public void salvar(Agenda agenda) {
        Log.d("MVC_Controller", "salvo" + agenda.toString());
        listaVip.putString("Titulo", agenda.getTitulo());
        listaVip.putString("Horario", agenda.getHorario());
        listaVip.putString("Local", agenda.getLocal());
        listaVip.apply();
        SQLiteDatabase db = agendaDB.getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("Titulo", agenda.getTitulo());
        dados.put("Horario", agenda.getHorario());
        dados.put("Local", agenda.getLocal());

        db.insert("Agenda", null, dados);
        db.close();
    }

    public Agenda buscar(Agenda novaAgenda) {
        novaAgenda.setTitulo(preferences.getString("Titulo", ""));
        novaAgenda.setHorario(preferences.getString("Horario", ""));
        novaAgenda.setLocal(preferences.getString("Local", ""));
        return novaAgenda;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }

}
