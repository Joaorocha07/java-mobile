package com.example.applistadecompras.controller;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.applistadecompras.database.ComprasDB;
import com.example.applistadecompras.model.Compras;
import com.example.applistadecompras.view.MainActivity;

public class ComprasController {
    private ComprasDB comprasDB;

    public ComprasController(Context context) {
        comprasDB = new ComprasDB(context);
    }

    public void salvar(Compras compras) {
        SQLiteDatabase db = comprasDB.getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("NomeDoProduto", compras.getNomeDoProduto());
        dados.put("QuantidadeDeProdutos", compras.getQuantidadeDeProdutos());
        dados.put("LocalParaComprar", compras.getLocalParaComprar());

        db.insert("Compras", null, dados);
        db.close();
    }
}
