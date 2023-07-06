package com.example.appgaseta.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appgaseta.R;
import com.example.appgaseta.controller.GazetaController;
import com.example.appgaseta.modal.Gazeta;

public class GazetaActivity extends AppCompatActivity {

    Gazeta gazeta;
    GazetaController gazetaController;

    EditText editPrecoDaGasolina;
    EditText editPrecoDoEtanol;
    TextView textResultado;

    Button btnLimpar;
    Button btnFinalizar;
    Button btnCalcular;
    Button btnSalvar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gazeta);

        gazetaController = new GazetaController(GazetaActivity.this);
        gazetaController.toString();

        gazeta = new Gazeta();
        gazetaController.buscar(gazeta);

        editPrecoDaGasolina = findViewById(R.id.editTextValorDaGasolina);
        editPrecoDoEtanol = findViewById(R.id.editTextValorDoEtanol);
        textResultado = findViewById(R.id.resultado);

        btnCalcular = findViewById(R.id.btn_calcular);
        btnLimpar = findViewById(R.id.btn_limpar);
        btnFinalizar = findViewById(R.id.btn_finalizar);
        btnSalvar = findViewById(R.id.btn_salvar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrecoDaGasolina.setText("");
                editPrecoDoEtanol.setText("");
                Toast.makeText(GazetaActivity.this, "Limpar", Toast.LENGTH_LONG).show();
                textResultado.setText("Resultado");
                gazetaController.limpar();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GazetaActivity.this, " Volte ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double gasolina = Double.parseDouble(editPrecoDaGasolina.getText().toString());
                double etanol = Double.parseDouble(editPrecoDoEtanol.getText().toString());
                double resultado = (etanol/gasolina);

                if(resultado <= 0.7){
                    textResultado.setText(String.format("Alcool %.2f",resultado));
                }else {
                    textResultado.setText(String.format("Gasolina %.2f",resultado));
                }
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gazeta.setEtanol(editPrecoDoEtanol.getText().toString());
                gazeta.setGasolina(editPrecoDaGasolina.getText().toString());
                Toast.makeText(GazetaActivity.this, "Salvo com sucesso" + gazeta.toString(), Toast.LENGTH_SHORT).show();
                gazetaController.salvar(gazeta);
            }
        });

    }
}
