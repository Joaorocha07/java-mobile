package com.example.appgaseta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.appgaseta.modal.Pessoa;
import com.example.appgaseta.view.MainActivity;

public class PessoaController {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciada...");
        return super.toString();
    }

    public void salvar(Pessoa outraPessoa) {
        Log.d("MVC_Controller", "Salvo: " + outraPessoa.toString());
        listaVip.putString("valorDaGasolina", outraPessoa.getValorDaGasolina());
        listaVip.putString("valorDoEtanol", outraPessoa.getValorDoEtanol());
        listaVip.apply();
    }

    public Pessoa procurar(Pessoa outraPessoa){
        outraPessoa.setValorDaGasolina(preferences.getString("valorDaGasolina", ""));
        outraPessoa.setValorDoEtanol(preferences.getString("valorDoEtanol", ""));
        return outraPessoa;
    }

    public void limpar(){
        listaVip.clear();
        listaVip.apply();
    }
}
