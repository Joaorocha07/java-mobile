package com.example.applistadecompras.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applistadecompras.R;
import com.example.applistadecompras.controller.ComprasController;
import com.example.applistadecompras.model.Compras;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    Compras novaCompra;
    Compras novaCompraDaAulaDeHoje;
    ComprasController ComprasController;

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

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

        novaCompra = new Compras();

        ComprasController = new ComprasController();
        ComprasController.toString();

        novaCompraDaAulaDeHoje = new Compras();
        novaCompraDaAulaDeHoje.setNomeDoProduto(preferences.getString("Nome do produto", ""));
        novaCompraDaAulaDeHoje.setQuantidadeDeProdutos(preferences.getString("Quantidade de produtos", ""));
        novaCompraDaAulaDeHoje.setLocalParaComprar(preferences.getString("Local para comprar", ""));

        editNomeDoProdutos.setText(novaCompraDaAulaDeHoje.getNomeDoProduto());
        editQuantidadeDeProdutos.setText(novaCompraDaAulaDeHoje.getQuantidadeDeProdutos());
        editLocalParaComprar.setText(novaCompraDaAulaDeHoje.getLocalParaComprar());

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

                listaVip.clear();
                listaVip.apply();

                Toast.makeText(MainActivity.this,"Limpo com sucesso!", Toast.LENGTH_LONG).show();
            }
        });

        editBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novaCompra.setNomeDoProduto(editNomeDoProdutos.getText().toString());
                novaCompra.setQuantidadeDeProdutos(editQuantidadeDeProdutos.getText().toString());
                novaCompra.setLocalParaComprar(editLocalParaComprar.getText().toString());

                Toast.makeText(MainActivity.this, "Dados salvos" + novaCompra.toString(), Toast.LENGTH_LONG).show();
                ComprasController.salvar(novaCompra);

                listaVip.putString("Nome do produto", novaCompra.getNomeDoProduto());
                listaVip.putString("Quantidade de produtos", novaCompra.getQuantidadeDeProdutos());
                listaVip.putString("Local para comprar", novaCompra.getLocalParaComprar());
                listaVip.apply();

                ComprasController.salvar(novaCompra);
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