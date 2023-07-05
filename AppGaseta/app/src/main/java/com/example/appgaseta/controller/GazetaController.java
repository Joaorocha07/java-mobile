package com.example.appgaseta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.appgaseta.modal.Gazeta;
import com.example.appgaseta.view.GazetaActivity;

public class GazetaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public GazetaController(GazetaActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_controllergazeta", "ControllerGazeta Iniciado");
        return super.toString();
    }

    public Gazeta salvar(Gazeta gazeta) {
        Log.d("MVP_MVC_controller", "Salvo: " + gazeta.toString());
        listaVip.putString("Etanol", gazeta.getEtanol());
        listaVip.putString("Etanol", gazeta.getEtanol());
        listaVip.putString("Gasolina", gazeta.getGasolina());
        listaVip.apply();
        return gazeta;
    }

    public Gazeta buscar(Gazeta gazeta) {
        gazeta.setEtanol(preferences.getString("Etanol", ""));
        gazeta.setGasolina(preferences.getString("Gasolina", ""));
        return gazeta;
    }

    public void limpar (){
        listaVip.clear();
        listaVip.apply();
    }

}

