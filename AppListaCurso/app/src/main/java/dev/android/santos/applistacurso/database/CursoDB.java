package dev.android.santos.applistacurso.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CursoDB extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "curso.db";
    private static final int VERSAO_BANCO = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public CursoDB(Context context) {

        super(context, NOME_BANCO, null, VERSAO_BANCO);

        db=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Curso (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Nome TEXT," +
                "Sobrenome TEXT," +
                "CursoInteressado TEXT," +
                "TelefoneDeContato TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void salvarDados(String tabela, ContentValues dados){
        db.insert(tabela,null,dados);
    }
}
