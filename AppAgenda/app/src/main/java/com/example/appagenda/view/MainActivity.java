package com.example.appagenda.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appagenda.R;
import com.example.appagenda.controller.AgendaController;
import com.example.appagenda.controller.PessoaController;
import com.example.appagenda.model.Agenda;
import com.example.appagenda.model.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AgendaController agendaController;
    Agenda novaAgenda;

    List<String> nomesDaAgenda;

    EditText editTitulo;
    EditText editHorario;
    EditText editLocal;

    Button editBtnSalvar;
    Button editBtnLimpar;
    Button editBtnFinalizar;

    Spinner edit_Spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PessoaController pessoaController = new PessoaController();

        nomesDaAgenda = pessoaController.dadosSpinner();

        agendaController = new AgendaController(MainActivity.this);
        agendaController.toString();

        novaAgenda = new Agenda();

        editTitulo = findViewById(R.id.editTextTitulo);
        editHorario = findViewById(R.id.editTextHorario);
        editLocal = findViewById(R.id.editTextLocal);

        editBtnSalvar = findViewById(R.id.btnSalvar);
        editBtnLimpar = findViewById(R.id.btnLimpar);
        editBtnFinalizar = findViewById(R.id.btnFinalizar);

        edit_Spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pessoaController.dadosSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        edit_Spinner.setAdapter(adapter);


        editBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = editTitulo.getText().toString();
                String horario = editHorario.getText().toString();
                String local = editLocal.getText().toString();

                Agenda agenda = new Agenda();
                agenda.setTitulo(titulo);
                agenda.setHorario(horario);
                agenda.setLocal(local);

                agendaController.salvar(agenda);

                Toast.makeText(MainActivity.this, "Dados salvos" + novaAgenda.toString(), Toast.LENGTH_LONG).show();
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