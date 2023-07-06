package com.example.appgazetaversao2.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GazetaDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "gazeta.db";
    public static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public GazetaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlTabelaCombustivel = "CREATE TABLE Combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomeCombustivel TEXT, " +
                "precoCombustivel REAL," +
                "resultado TEXT)";
        db.execSQL(sqlTabelaCombustivel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //TODO: criar métodos para implementar um CRUD
    //c = Create criar o banco de dados e as linhas
    //create database nome_banco_de_dados.db ()SQL
    //create table(SQL)

    // R Retrive recuperar os dados salvos das tabelas
    // Select * from table (SQL)

    // Update = alterar os dados que ja existem em uma tabela
}
