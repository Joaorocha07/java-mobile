package com.example.appgazetaversao2.controller;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.appgazetaversao2.model.Combustivel;
import com.example.appgazetaversao2.view.GazetaActivity;

public class CombustivelController {
    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public CombustivelController(GazetaActivity activity){
        preferences = activity.getSharedPreferences(NOME_PREFERENCES,0);
        listaVip = preferences.edit();
    }

    public Combustivel salvar(Combustivel combustivel) {
        Log.d("MVC_Controller", "salvo" + combustivel.toString());
        listaVip.putString("Combustivel", combustivel.getNomeCombustivel());
        listaVip.putFloat("Preço do combustivel", (float) combustivel.getPrecoCombustivel());
        listaVip.putString("Resultado", combustivel.getResultado());
        listaVip.apply();
        return combustivel;
    }

    public void limpar(){
        listaVip.clear();
        listaVip.apply();
    }

}
