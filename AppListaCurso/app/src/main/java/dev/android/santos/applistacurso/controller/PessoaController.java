package dev.android.santos.applistacurso.controller;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.annotation.NonNull;

import dev.android.santos.applistacurso.database.CursoDB;
import dev.android.santos.applistacurso.model.Pessoa;
import dev.android.santos.applistacurso.view.MainActivity;

public class PessoaController {
    private CursoDB cursoDB;

    public PessoaController(Context context) {
        cursoDB = new CursoDB(context);
    }

    public void salvar(Pessoa pessoa) {
        SQLiteDatabase db = cursoDB.getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("Nome", pessoa.getPrimeiroNome());
        dados.put("Sobrenome", pessoa.getSegundoNome());
        dados.put("CursoInteressado", pessoa.getCursoDesejado());
        dados.put("TelefoneDeContato", pessoa.getTelefoneContato());
        db.insert("Curso", null, dados);
        db.close();
    }
}
