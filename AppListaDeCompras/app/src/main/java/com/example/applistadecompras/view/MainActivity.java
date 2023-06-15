package com.example.applistadecompras.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.applistadecompras.R;
import com.example.applistadecompras.controller.ComprasController;
import com.example.applistadecompras.controller.PessoaController;
import com.example.applistadecompras.model.Compras;
import com.example.applistadecompras.model.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ComprasController ComprasController;
    Compras novaCompra;
    List<String> listaCompras;

    EditText editNomeDoProduto;
    EditText editQuantidadeDeProdutos;
    EditText editlocalParaComprar;

    Button editBtnSalvar;
    Button editBtnLimpar;
    Button editBtnFinalizar;

    Spinner edit_Spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PessoaController pessoaController = new PessoaController();

        listaCompras = pessoaController.dadosSpinner();

        ComprasController = new ComprasController(MainActivity.this);
        ComprasController.toString();

        novaCompra = new Compras();

        ComprasController.buscar(novaCompra);

        editNomeDoProduto = findViewById(R.id.editTextNomeDoProduto);
        editlocalParaComprar = findViewById(R.id.editTextLocalParaComprar);
        editQuantidadeDeProdutos = findViewById(R.id.editTextQuantidadeDeProdutos);

        editBtnSalvar = findViewById(R.id.btn_salvar);
        editBtnLimpar = findViewById(R.id.btn_limpar);
        editBtnFinalizar = findViewById(R.id.btn_finalizar);

        edit_Spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pessoaController.dadosSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        edit_Spinner.setAdapter(adapter);

        editBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novaCompra.setNomeDoProduto(editNomeDoProduto.getText().toString());
                novaCompra.setLocalParaComprar(editlocalParaComprar.getText().toString());
                novaCompra.setQuantidadeDeProdutos(editQuantidadeDeProdutos.getText().toString());

                Toast.makeText(MainActivity.this, "Dados salvos" + novaCompra.toString(), Toast.LENGTH_LONG).show();

                ComprasController.salvar(novaCompra);
            }
        });

        editBtnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNomeDoProduto.setText("");
                editlocalParaComprar.setText("");
                editQuantidadeDeProdutos.setText("");
                Toast.makeText(MainActivity.this, "Limpo com Sucesso!", Toast.LENGTH_LONG).show();
                ComprasController.limpar();
            }
        });

        editBtnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Finalizado com Sucesso!", Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }
}