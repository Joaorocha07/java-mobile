package com.example.appgazetaversao2.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.appgazetaversao2.database.GazetaDB;
import com.example.appgazetaversao2.model.Combustivel;
import com.example.appgazetaversao2.view.GazetaActivity;

public class CombustivelController extends GazetaDB {
    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public CombustivelController(GazetaActivity activity){
        super(activity);
        preferences = activity.getSharedPreferences(NOME_PREFERENCES,0);
        listaVip = preferences.edit();
    }

    public Combustivel salvar(Combustivel combustivel) {

        ContentValues dados = new ContentValues();

        Log.d("MVC_Controller", "salvo" + combustivel.toString());
        listaVip.putString("Combustivel", combustivel.getNomeCombustivel());
        listaVip.putFloat("Preço do combustivel", (float) combustivel.getPrecoCombustivel());
        listaVip.putString("Resultado", combustivel.getResultado());
        listaVip.apply();

        dados.put("nomeCombustivel", combustivel.getNomeCombustivel());
        dados.put("precoCombustivel", combustivel.getPrecoCombustivel());
        dados.put("resultado", combustivel.getResultado());

        salvarObjeto("Combustivel", dados);

        return combustivel;
    }

    public void limpar(){
        listaVip.clear();
        listaVip.apply();
    }

}
