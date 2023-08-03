package com.example.applistadecomprasversaodois.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.applistadecomprasversaodois.database.ComprasDB;
import com.example.applistadecomprasversaodois.modal.Compras;

import java.util.ArrayList;
import java.util.List;

public class ComprasController {
    private ComprasDB comprasDB;

    public ComprasController(Context context) {
        comprasDB = new ComprasDB(context);
    }

    public void salvar(Compras compras) {
        SQLiteDatabase db = comprasDB.getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("Nome", compras.getNome());
        dados.put("Quantidade", compras.getQuantidade());

        db.insert("Compras", null, dados);
        db.close();
    }
}
