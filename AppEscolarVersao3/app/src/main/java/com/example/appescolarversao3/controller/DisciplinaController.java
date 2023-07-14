package com.example.appescolarversao3.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.appescolarversao3.database.EscolaDB;
import com.example.appescolarversao3.modal.Disciplina;

public class DisciplinaController {
    private EscolaDB escolaDB;

    public DisciplinaController(Context context) {
        escolaDB = new EscolaDB(context);
    }

    public void salvar(Disciplina disciplina) {
        SQLiteDatabase db = escolaDB.getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nomeAluno", disciplina.getNomeDoAluno());
        dados.put("materia", disciplina.getMateria());
        dados.put("notaPrimeiroBimestre", disciplina.getNotaPrimeiroBimestre());
        dados.put("notaSegundoBimestre", disciplina.getNotaSegundoBimestre());
        dados.put("notaTerceiroBimestre", disciplina.getNotaTerceiroBimestre());
        dados.put("notaQuartoBimestre", disciplina.getNotaQuartoBimestre());
        dados.put("resultado", disciplina.getResultadoMedia());

        db.insert("Escola", null, dados);
        db.close();
    }
}
