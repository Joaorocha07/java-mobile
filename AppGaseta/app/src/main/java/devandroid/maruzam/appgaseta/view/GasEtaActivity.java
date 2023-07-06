package devandroid.maruzam.appgaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.maruzam.appgaseta.apoio.UtilGasEta;
import devandroid.maruzam.appgaseta.controller.CombustivelController;
import devandroid.maruzam.appgaseta.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {

    CombustivelController controller;
    //declarar a classe

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

        setContentView(R.layout.activity_gaseta);

        controller = new CombustivelController(GasEtaActivity.this);

        //associação dos atributos

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        //pegar o click dos botões

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

                    resultado = UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol);

                    txtResultado.setText(resultado);

                    btnSalvar.setEnabled(true);


                }else {

                    Toast.makeText(GasEtaActivity.this,
                            "Digite os dados por favor!!!",
                            Toast.LENGTH_LONG).show();

                    btnSalvar.setEnabled(false);

                }

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Todo: Desabilitar o botão salvar
                //Todo: Edit Text InputType



                combustivelEtanol = new Combustivel();
                combustivelGasolina = new Combustivel();

                combustivelEtanol.setNomeCombustivel("Etanol");
                combustivelEtanol.setPrecoCombustivel(precoEtanol);

                combustivelGasolina.setNomeCombustivel("Gasolina");
                combustivelGasolina.setPrecoCombustivel(precoGasolina);

                combustivelGasolina.setResultado(UtilGasEta.calcularMelhorOpcao
                        (precoGasolina, precoEtanol));
                combustivelEtanol.setResultado(UtilGasEta.calcularMelhorOpcao
                        (precoGasolina, precoEtanol));

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

                Toast.makeText(GasEtaActivity.this,
                        "Obrigado por Utilizar Nosso Aplicativo!!!",
                        Toast.LENGTH_LONG).show();
                finish();

            }
        });

        Toast.makeText(GasEtaActivity.this,
                UtilGasEta.calcularMelhorOpcao(5.12,3.39),
                Toast.LENGTH_SHORT).show();
    }
}
