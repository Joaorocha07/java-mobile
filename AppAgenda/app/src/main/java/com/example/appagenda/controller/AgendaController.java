package com.example.appagenda.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.appagenda.model.Agenda;

public class AgendaController {
    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "toString: ");
        return super.toString();
    }

    public void salvar(Agenda novaAgenda) {
        Log.d("MVC_Controller", "salvo" + novaAgenda.toString());
    }
}
