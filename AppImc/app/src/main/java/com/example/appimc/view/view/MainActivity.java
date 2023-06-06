package com.example.appimc.view.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appimc.R;
import com.example.appimc.view.controller.PessoaController;
import com.example.appimc.view.model.PessoaModel;

public class MainActivity extends AppCompatActivity {

    PessoaController PessoaController;
    PessoaModel novaPessoa;

    EditText editAltura;
    EditText editPeso;

    Button editBtnCalcular;
    Button editBtnSalvar;
    Button editBtnLimpar;
    Button editBtnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PessoaController = new PessoaController(MainActivity.this);
        PessoaController.toString();

        novaPessoa = new PessoaModel();
        PessoaController.buscar(novaPessoa);

        editAltura = findViewById(R.id.editTextAltura);
        editPeso = findViewById(R.id.editTextPeso);

        editBtnCalcular = findViewById(R.id.btnCalcular);
        editBtnSalvar = findViewById(R.id.btnSalvar);
        editBtnLimpar = findViewById(R.id.btnLimpar);
        editBtnFinalizar = findViewById(R.id.btnFinalizar);

        editBtnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        editBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novaPessoa.setPeso(editPeso.getText().toString());
                novaPessoa.setAltura(editAltura.getText().toString());
                Toast.makeText(MainActivity.this, "Dados salvos" + novaPessoa.toString(), Toast.LENGTH_LONG).show();
                PessoaController.salvar(novaPessoa);
            }
        });

        editBtnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPeso.setText("");
                editAltura.setText("");
                Toast.makeText(MainActivity.this,"Limpo com sucesso", Toast.LENGTH_LONG).show();
                PessoaController.limpar();
            }
        });

        editBtnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Voltar", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}