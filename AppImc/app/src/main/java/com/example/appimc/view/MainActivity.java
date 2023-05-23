package com.example.appimc.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appimc.R;
import com.example.appimc.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Pessoa outraPessoa;

    EditText editPeso;
    EditText editAltura;

    String dadosPessoa;
    String dadosOutaPessoa;

    Button editBtnCalcular;
    Button editBtnLimpar;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPeso("55");
        pessoa.setAltura("1.68");

        outraPessoa = new Pessoa();
        outraPessoa.setPeso("65");
        outraPessoa.setAltura("1.65");

        editPeso = findViewById(R.id.textPeso);
        editAltura = findViewById(R.id.textAltura);

        editBtnLimpar = findViewById(R.id.btn_limpar);
        editBtnCalcular = findViewById(R.id.btn_calcular);

        editBtnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPeso.setText("");
                editAltura.setText("");
                Toast.makeText(MainActivity.this,"Limpo",Toast.LENGTH_LONG).show();
            }
        });

        dadosPessoa = "Seu peso: ";
        dadosPessoa += pessoa.getAltura();
        dadosPessoa += "Sua Altura: ";
        dadosPessoa += pessoa.getPeso();

        dadosOutaPessoa += "Seu peso: ";
        dadosOutaPessoa += outraPessoa.getPeso();
        dadosOutaPessoa += "Sua Altura: ";
        dadosOutaPessoa += outraPessoa.getAltura();

        Log.i("ProgramacaoPOO", pessoa.toString());
        Log.i("ProgramacaoPOO", outraPessoa.toString());
    }
}
