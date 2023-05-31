package com.example.appagenda.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appagenda.R;
import com.example.appagenda.controller.AgendaController;
import com.example.appagenda.model.Agenda;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    AgendaController agendaController;
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

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);

        novaAgenda = new Agenda();

        novaAgenda.setTitulo(preferences.getString("Titulo", ""));
        novaAgenda.setHorario(preferences.getString("Horario", ""));
        novaAgenda.setLocal(preferences.getString("Local", ""));

        editTitulo = findViewById(R.id.editTextTitulo);
        editHorario = findViewById(R.id.editTextHorario);
        editLocal = findViewById(R.id.editTextLocal);

        editBtnSalvar = findViewById(R.id.btnSalvar);
        editBtnLimpar = findViewById(R.id.btnLimpar);
        editBtnFinalizar = findViewById(R.id.btnFinalizar);

        agendaController = new AgendaController();
        agendaController.toString();

        editBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novaAgenda.setTitulo(editTitulo.getText().toString());
                novaAgenda.setHorario(editHorario.getText().toString());
                novaAgenda.setLocal(editLocal.getText().toString());
                agendaController.salvar(novaAgenda);

                Toast.makeText(MainActivity.this, "Dados salvos" + novaAgenda.toString(), Toast.LENGTH_LONG).show();
                agendaController.salvar(novaAgenda);

                listaVip.putString("Titulo", novaAgenda.getTitulo());
                listaVip.putString("Horario", novaAgenda.getHorario());
                listaVip.putString("Local", novaAgenda.getLocal());
                listaVip.apply();

                agendaController.salvar(novaAgenda);

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