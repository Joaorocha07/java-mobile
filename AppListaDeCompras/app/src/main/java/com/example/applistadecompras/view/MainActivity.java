package com.example.applistadecompras.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        novaCompra = new Compras();

        editNomeDoProdutos = findViewById(R.id.editTextNomeDoProduto);
        editQuantidadeDeProdutos = findViewById(R.id.editTextQuantidadeDeProdutos);
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
                Toast.makeText(MainActivity.this,"Limpo com sucesso!", Toast.LENGTH_LONG).show();
            }
        });

        editBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novaCompra.setNomeDoProduto(editNomeDoProdutos.getText().toString());
                novaCompra.setQuantidadeDeProdutos(editQuantidadeDeProdutos.getText().toString());
                novaCompra.setLocalParaComprar(editLocalParaComprar.getText().toString());
                Toast.makeText(MainActivity.this,"Limpo com sucesso!", Toast.LENGTH_LONG).show();
            }
        });

        editBtnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Voltar",Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}