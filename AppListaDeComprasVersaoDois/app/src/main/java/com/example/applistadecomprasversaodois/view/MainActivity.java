package com.example.applistadecomprasversaodois.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applistadecomprasversaodois.R;
import com.example.applistadecomprasversaodois.controller.ComprasController;
import com.example.applistadecomprasversaodois.modal.Compras;

public class MainActivity extends AppCompatActivity {

    private ComprasController comprasController;
    Compras compras;

    private EditText edit_nomeDoItem;
    private EditText edit_quantidadeDoItem;
    Button btn_Adicionar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comprasController = new ComprasController(this);

        compras = new Compras();

        edit_nomeDoItem = findViewById(R.id.editTextNomeDoItem);
        edit_quantidadeDoItem = findViewById(R.id.editTextQuantidadeDeItens);

        Button btn_Adicionar = findViewById(R.id.buttonAdicionar);
        btn_Adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }
        });

    }
}