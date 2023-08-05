package com.example.listacompras.controller;

import android.content.Context;

import com.example.listacompras.database.ComprasDB;
import com.example.listacompras.model.ComprasItem;

import java.util.ArrayList;

public class ComprasController {
    private ComprasDB comprasDB;

    public ComprasController(Context context) {
        comprasDB = new ComprasDB(context);
    }

    public ArrayList<ComprasItem> getItems() {
        return comprasDB.getAllItems();
    }

    public long addItem(String name, int quantity) {
        ComprasItem newItem = new ComprasItem();
        newItem.setName(name);
        newItem.setQuantity(quantity);
        return comprasDB.addItem(newItem);
    }

    public void deleteItem(int itemId) {
        comprasDB.deleteItem(itemId);
    }
}
