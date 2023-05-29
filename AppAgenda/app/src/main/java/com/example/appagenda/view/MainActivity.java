package com.example.appagenda.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appagenda.R;
import com.example.appagenda.model.Agenda;

public class MainActivity extends AppCompatActivity {

    Agenda novaAgenda;

    EditText editTitulo;
    EditText editHorario;
    EditText editLocal;

    Button editBtnSalvar;
    Button editBtnLimpar;
    Button editBtnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        novaAgenda = new Agenda();

        editTitulo = findViewById(R.id.editTextTitulo);
        editHorario = findViewById(R.id.editTextHorario);
        editLocal = findViewById(R.id.editTextLocal);

        editBtnSalvar = findViewById(R.id.btnSalvar);
        editBtnLimpar = findViewById(R.id.btnLimpar);
        editBtnFinalizar = findViewById(R.id.btnFinalizar);

        editBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novaAgenda.setTitulo(editTitulo.getText().toString());
                novaAgenda.getHorario(editHorario.getText().toString());
                novaAgenda.getLocal(editLocal.getText().toString());
                Toast.makeText(MainActivity.this, "Salvo com Sucesso!", Toast.LENGTH_LONG).show();
            }
        });

        editBtnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTitulo.setText("");
                editHorario.setText("");
                editLocal.setText("");
                Toast.makeText(MainActivity.this, "Limpo com Sucesso!", Toast.LENGTH_LONG).show();
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