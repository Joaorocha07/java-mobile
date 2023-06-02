package com.example.appagenda.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.appagenda.model.Agenda;
import com.example.appagenda.view.MainActivity;

public class AgendaController {

    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public AgendaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "toString: ");
        return super.toString();
    }

    public Agenda salvar(Agenda novaAgenda) {
        Log.d("MVC_Controller", "salvo" + novaAgenda.toString());
        listaVip.putString("Titulo", novaAgenda.getTitulo());
        listaVip.putString("Horario", novaAgenda.getHorario());
        listaVip.putString("Local", novaAgenda.getLocal());
        listaVip.apply();
        return novaAgenda;
    }

    public Agenda buscar(Agenda novaAgenda) {
        novaAgenda.setTitulo(preferences.getString("Titulo", ""));
        novaAgenda.setHorario(preferences.getString("Horario", ""));
        novaAgenda.setLocal(preferences.getString("Local", ""));
        return novaAgenda;
    }

    public void limpar(Agenda novaAgenda) {
        listaVip.clear();
        listaVip.apply();
    }

}
