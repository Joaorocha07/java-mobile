package com.example.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appgaseta.R;
import com.example.appgaseta.controller.PessoaController;
import com.example.appgaseta.modal.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;

    Pessoa outraPessoa;

    EditText edit_ValorDaGasolina;
    EditText edit_ValorDoEtanol;

    Button btn_Calcular;
    Button btn_Limpar;
    Button btn_Finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new PessoaController(MainActivity.this);

        controller.toString();

        outraPessoa = new Pessoa();
        controller.procurar(outraPessoa);

        edit_ValorDaGasolina = findViewById(R.id.editTextValorDaGasolina);
        edit_ValorDoEtanol = findViewById(R.id.editTextValorDoEtanol);

        edit_ValorDaGasolina.setText(outraPessoa.getValorDaGasolina());
        edit_ValorDoEtanol.setText(outraPessoa.getValorDoEtanol());

        btn_Limpar = findViewById(R.id.btn_limpar);
        btn_Calcular = findViewById(R.id.btn_calcular);
        btn_Finalizar = findViewById(R.id.btn_finalizar);

        btn_Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Informacoes Limpadas", Toast.LENGTH_LONG).show();
                edit_ValorDaGasolina.setText("");
                edit_ValorDoEtanol.setText("");
                controller.limpar();
            }
        });

        btn_Finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte sempre!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btn_Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Log.i("POOAndroid", outraPessoa.toString());
    }
}