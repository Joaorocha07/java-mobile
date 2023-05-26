package com.example.applistadecompras.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applistadecompras.R;
import com.example.applistadecompras.model.Compras;

public class MainActivity extends AppCompatActivity {

    Compras novaCompra;

    EditText editNomeDoProdutos;
    EditText editQuantidadeDeProdutos;
    EditText editLocalParaComprar;

    Button editBtnLimpar;
    Button editBtnSalvar;
    Button editBtnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        novaCompra = new Compras();

        editNomeDoProdutos = findViewById(R.id.editTextNomeDoProduto);
        editQuantidadeDeProdutos = findViewById(R.id.editTextNomeDoProduto);
        editLocalParaComprar = findViewById(R.id.editTextLocalParaComprar);

        editBtnLimpar = findViewById(R.id.btn_limpar);
        editBtnSalvar = findViewById(R.id.btn_salvar);
        editBtnFinalizar = findViewById(R.id.btn_finalizar);

        editBtnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNomeDoProdutos.setText("");
                editQuantidadeDeProdutos.setText("");
                editLocalParaComprar.setText("");
            }
        });


    }
}
