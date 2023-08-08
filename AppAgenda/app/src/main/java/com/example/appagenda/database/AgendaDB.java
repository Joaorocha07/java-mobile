package com.example.appagenda.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.appagenda.model.Agenda;

public class AgendaDB extends SQLiteOpenHelper {
    private static final String DB_NAME = "agenda.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public AgendaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTabelaCombustivel = "CREATE TABLE Agenda   (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Titulo TEXT," +
                "Horario TEXT, " +
                "Local TEXT)";
        db.execSQL(sqlTabelaCombustivel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void salvar(Agenda agenda) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("Titulo", agenda.getTitulo());
        dados.put("Horario", agenda.getHorario());
        dados.put("Local", agenda.getLocal());

        db.insert("Agenda", null, dados);
    }
}
