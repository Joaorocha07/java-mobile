package com.example.applistadecomprasversaodois.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.applistadecomprasversaodois.modal.Compras;

import java.util.ArrayList;

public class ComprasDB extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "compras.db";
    private static final int VERSAO_BANCO = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public ComprasDB(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
        db=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Compras (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT," +
                "quantidade TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarDados(String tabela, ContentValues dados){
        db.insert(tabela,null, dados);
    }

    public ArrayList<Compras> getAllItems() {
        ArrayList<Compras> itemsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Compras", null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int itemId = cursor.getInt(cursor.getColumnIndex("id"));
                String itemNome = cursor.getString(cursor.getColumnIndex("nome"));
                int itemQuantidade = cursor.getInt(cursor.getColumnIndex("quantidade"));

                Compras item = new Compras();
                item.setId(itemId);
                item.setNome(itemNome);
                item.setQuantidade(String.valueOf(itemQuantidade));

                itemsList.add(item);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return itemsList;
    }

    public void deleteItem(int itemId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Compras", "id" + "=?", new String[]{String.valueOf(itemId)});
    }

}
