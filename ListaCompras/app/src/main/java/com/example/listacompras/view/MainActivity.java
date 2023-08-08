package com.example.listacompras.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listacompras.R;
import com.example.listacompras.controller.ComprasController;
import com.example.listacompras.model.ComprasItem;
import com.example.listacompras.model.ComprasItemAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextItem, editTextQuantity;
    private Button btnAddItem;
    private ListView listViewItems;
    private ArrayList<ComprasItem> itemsList;
    private ComprasItemAdapter comprasItemAdapter;
    private ComprasController comprasController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextItem = findViewById(R.id.editTextNomeDoItem);
        editTextQuantity = findViewById(R.id.editTextQuantidadeDeItens);
        btnAddItem = findViewById(R.id.buttonAdicionar);
        listViewItems = findViewById(R.id.listViewItems);

        itemsList = new ArrayList<>();
        comprasItemAdapter = new ComprasItemAdapter(this, itemsList);
        listViewItems.setAdapter(comprasItemAdapter);

        comprasController = new ComprasController(this);
        loadItemsFromDatabase();

        comprasItemAdapter.setOnDeleteButtonClickListener(new ComprasItemAdapter.OnDeleteButtonClickListener() {
            @Override
            public void onDeleteButtonClick(int position) {
                deleteItemFromDatabase(position);
            }
        });

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToDatabase();
            }
        });
    }

    private void loadItemsFromDatabase() {
        itemsList.clear();
        itemsList.addAll(comprasController.getItems());
        comprasItemAdapter.notifyDataSetChanged();
    }

    private void addItemToDatabase() {
        String itemName = editTextItem.getText().toString().trim();
        String quantityString = editTextQuantity.getText().toString().trim();

        if (!itemName.isEmpty()) {
            int itemQuantity = 0;
            if (!quantityString.isEmpty()) {
                itemQuantity = Integer.parseInt(quantityString);
            }

            long itemId = comprasController.addItem(itemName, itemQuantity);

            if (itemId != -1) {
                loadItemsFromDatabase();
                editTextItem.getText().clear();
                editTextQuantity.getText().clear();
            } else {
                Toast.makeText(this, "Falha ao adicionar item", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Insira o nome do item", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteItemFromDatabase(int position) {
        ComprasItem item = itemsList.get(position);
        comprasController.deleteItem(item.getId());
        loadItemsFromDatabase();
    }
}