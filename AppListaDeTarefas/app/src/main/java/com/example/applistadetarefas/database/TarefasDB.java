package com.example.applistadetarefas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TarefasDB extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "tarefas.db";
    private static final int VERSAO_BANCO = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public TarefasDB(Context context) {

        super(context, NOME_BANCO, null, VERSAO_BANCO);

        db=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Tarefas (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomeAluno TEXT," +
                "materia TEXT," +
                "notaPrimeiroBimestre TEXT," +
                "notaSegundoBimestre TEXT," +
                "notaTerceiroBimestre TEXT," +
                "notaQuartoBimestre TEXT," +
                "resultado TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void salvarDados(String tabela, ContentValues dados){
        db.insert(tabela,null,dados);
    }
}
