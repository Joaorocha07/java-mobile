package com.example.appgazetaversao2.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appgazetaversao2.R;
import com.example.appgazetaversao2.apoio.UtilGazeta;
import com.example.appgazetaversao2.controller.CombustivelController;
import com.example.appgazetaversao2.model.Combustivel;

public class GazetaActivity extends AppCompatActivity {
    //declarar a classe
    CombustivelController controller;

    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    //declarar os atributos

    EditText editGasolina;
    EditText editEtanol;

    TextView  txtResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    //declarar atributos para o cauculo

    double precoGasolina;
    double precoEtanol;
    String resultado;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gazeta);

        controller = new CombustivelController(GazetaActivity.this);

        // associação dos atributos

        editGasolina = findViewById(R.id.editTextValorDaGasolina);
        editEtanol = findViewById(R.id.editTextValorDoEtanol);

        txtResultado = findViewById(R.id.resultado);

        btnCalcular = findViewById(R.id.btn_calcular);
        btnSalvar = findViewById(R.id.btn_salvar);
        btnLimpar = findViewById(R.id.btn_limpar);
        btnFinalizar = findViewById(R.id.btn_finalizar);

        // pegar o click dos botões

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOk = true;

                if (TextUtils.isEmpty(editGasolina.getText())){
                    editGasolina.setError("Obrigatório");
                    editGasolina.requestFocus();
                    isDadosOk = false;
                }

                if (TextUtils.isEmpty(editEtanol.getText())){
                    editEtanol.setError("Obrigatório");

                    editEtanol.requestFocus();

                    isDadosOk = false;
                }

                if (isDadosOk){
                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());

                    resultado = UtilGazeta.calcularMelhorOpcao(precoGasolina, precoEtanol);

                    txtResultado.setText(resultado);

                    btnSalvar.setEnabled(true);
                }else {
                    Toast.makeText(GazetaActivity.this,"Digite os dados por favor!!!",Toast.LENGTH_LONG).show();
                    btnSalvar.setEnabled(false);
                }

            }
        });

        //Todo: Desabilitar o botão salvar
        //Todo: Edit Text InputType
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                combustivelEtanol = new Combustivel();
                combustivelGasolina = new Combustivel();

                combustivelEtanol.setNomeCombustivel("Etanol");
                combustivelEtanol.setPrecoCombustivel(precoEtanol);

                combustivelGasolina.setNomeCombustivel("Gasolina");
                combustivelGasolina.setPrecoCombustivel(precoGasolina);

                combustivelGasolina.setResultado(UtilGazeta.calcularMelhorOpcao(precoGasolina, precoEtanol));
                combustivelEtanol.setResultado(UtilGazeta.calcularMelhorOpcao(precoGasolina, precoEtanol));

                controller.salvar(combustivelGasolina);
                controller.salvar(combustivelEtanol);
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editEtanol.setText("");
                editGasolina.setText("");

                btnSalvar.setEnabled(false);

                controller.limpar();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GazetaActivity.this,"Obrigado por Utilizar Nosso Aplicativo!!!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        Toast.makeText(GazetaActivity.this, UtilGazeta.calcularMelhorOpcao(5.12,3.39), Toast.LENGTH_SHORT).show();
    }

}
