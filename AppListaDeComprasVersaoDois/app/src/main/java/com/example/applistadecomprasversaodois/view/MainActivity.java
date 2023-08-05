package com.example.applistadecomprasversaodois.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.applistadecomprasversaodois.R;
import com.example.applistadecomprasversaodois.controller.ComprasController;
import com.example.applistadecomprasversaodois.modal.Adpter;
import com.example.applistadecomprasversaodois.modal.Compras;
import com.example.applistadecomprasversaodois.modal.Interface;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Interface.ClickRecyclerView_Interface  {
    Adpter adpter;

    EditText edit_nomeDoItem;
    EditText edit_quantidadeDoItem;
    Button btn_Adicionar;

    ComprasController comprasController;
    Compras compras;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Compras> itemListas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comprasController = new ComprasController(this);

        compras = new Compras();

        edit_nomeDoItem = findViewById(R.id.editTextNomeDoItem);
        edit_quantidadeDoItem = findViewById(R.id.editTextQuantidadeDeItens);

        setaRecyclerView();
        setaButtons();
        listenersButtons();
    }

    public void setaRecyclerView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adpter = new Adpter(this, itemListas, this);
        mRecyclerView.setAdapter(adpter);
    }

    public void setaButtons(){
        btn_Adicionar = findViewById(R.id.buttonAdicionar);
    }

    /**
     * Aqui é o método onde trata o clique em um item da lista
     */
    @Override
    public void onCustomClick(Object object) {

    }

    /**
     * Chama os listeners para os botões
     */
    public void listenersButtons() {
        comprasController = new ComprasController(MainActivity.this);

        btn_Adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nomeDoItem = edit_nomeDoItem.getText().toString();
                String quantidadeDoItem = edit_quantidadeDoItem.getText().toString();

                if (nomeDoItem.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preencha o nome do item!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (quantidadeDoItem.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preencha a quantidade!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Compras compras = new Compras();
                compras.setNome(nomeDoItem);
                compras.setQuantidade(quantidadeDoItem);
                comprasController.salvar(compras);

                Toast.makeText(MainActivity.this, "Compras salvo com sucesso", Toast.LENGTH_SHORT).show();

                itemListas.add(compras);
                adpter.notifyDataSetChanged();
            }
        });
    }

    private void deleteItemFromDatabase(int position) {
        ComprasController item = itemListas.get(position);
        shoppingListController.deleteItem(item.getId());
        loadItemsFromDatabase();
    }

}