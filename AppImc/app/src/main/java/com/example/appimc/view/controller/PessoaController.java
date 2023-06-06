package com.example.appimc.view.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.appimc.view.model.PessoaModel;
import com.example.appimc.view.view.MainActivity;

public class PessoaController {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciado");
        return super.toString();
    }

    public void salvar(PessoaModel novaPessoa) {
        Log.d("MVC_Controller", "Salvo" + novaPessoa.toString());
        listaVip.putString("Sua Altura", novaPessoa.getAltura());
        listaVip.putString("Seu Peso", novaPessoa.getPeso());
        listaVip.apply();
    }

    public PessoaModel buscar(PessoaModel novaPessoa) {
        novaPessoa.setAltura(preferences.getString("Sua Altura", ""));
        novaPessoa.setPeso(preferences.getString("Seu Peso", ""));
        return novaPessoa;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }

}
