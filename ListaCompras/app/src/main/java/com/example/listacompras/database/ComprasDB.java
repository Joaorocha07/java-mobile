package com.example.listacompras.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.listacompras.model.ComprasItem;

import java.util.ArrayList;

public class ComprasDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "shopping_list.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "items";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_QUANTITY = "quantity";

    private static final String CREATE_TABLE_ITEMS =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_QUANTITY + " INTEGER)";

    public ComprasDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ITEMS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addItem(ComprasItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, item.getName());
        values.put(COLUMN_QUANTITY, item.getQuantity());
        return db.insert(TABLE_NAME, null, values);
    }

    public ArrayList<ComprasItem> getAllItems() {
        ArrayList<ComprasItem> itemsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int itemId = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String itemName = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                int itemQuantity = cursor.getInt(cursor.getColumnIndex(COLUMN_QUANTITY));

                ComprasItem item = new ComprasItem();
                item.setId(itemId);
                item.setName(itemName);
                item.setQuantity(itemQuantity);

                itemsList.add(item);
            } while (cursor.moveToNext());

            cursor.close();
        }

        return itemsList;
    }

    public void deleteItem(int itemId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{String.valueOf(itemId)});
    }
}
