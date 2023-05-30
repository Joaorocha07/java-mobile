package com.example.applistadecompras.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.applistadecompras.model.Compras;

public class ComprasController {
    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciado");
        return super.toString();
    }

    public void salvar(Compras novaCompra) {
        Log.d("MVC_Controller", "Salvo" + novaCompra.toString());
    }
}
