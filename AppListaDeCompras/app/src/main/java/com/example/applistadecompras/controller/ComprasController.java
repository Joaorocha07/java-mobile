package com.example.applistadecompras.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.applistadecompras.model.Compras;
import com.example.applistadecompras.view.MainActivity;

public class ComprasController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public ComprasController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciado");
        return super.toString();
    }

    public Compras salvar(Compras novaCompra) {
        Log.d("MVC_Controller", "salvo" + novaCompra.toString());
        listaVip.putString("Nome do produto", novaCompra.getNomeDoProduto());
        listaVip.putString("Local Para Comprar", novaCompra.getLocalParaComprar());
        listaVip.putString("Quantidade de Produtos", novaCompra.getQuantidadeDeProdutos());
        listaVip.apply();
        return novaCompra;
    }

    public Compras buscar(Compras novaCompra) {
        novaCompra.setNomeDoProduto(preferences.getString("Nome do produto", ""));
        novaCompra.setLocalParaComprar(preferences.getString("Local Para Comprar", ""));
        novaCompra.setQuantidadeDeProdutos(preferences.getString("Quantidade de Produtos", ""));
        return novaCompra;
    }

    public void limpar(Compras novaCompra) {
        listaVip.clear();
        listaVip.apply();
    }
}
