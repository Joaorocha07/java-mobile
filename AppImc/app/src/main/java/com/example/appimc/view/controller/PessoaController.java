package com.example.appimc.view.controller;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.appimc.view.database.PessoaDB;
import com.example.appimc.view.model.PessoaModel;
import com.example.appimc.view.view.MainActivity;

public class PessoaController {
    private PessoaDB pessoaDB;

    public PessoaController(Context context) {
        pessoaDB = new PessoaDB(context);
    }

    public void salvar(PessoaModel pessoa) {
        SQLiteDatabase db = pessoaDB.getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("Altura", pessoa.getAltura());
        dados.put("Peso", pessoa.getPeso());

        db.insert("Pessoa", null, dados);
        db.close();
    }
}
