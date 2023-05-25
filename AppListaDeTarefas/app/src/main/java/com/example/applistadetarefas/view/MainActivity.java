package com.example.applistadetarefas.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applistadetarefas.R;
import com.example.applistadetarefas.model.Tarefa;

public class MainActivity extends AppCompatActivity {
    Tarefa pessoa;

    EditText editNomeDaTarefa;
    EditText editDataDeConclusao;
    EditText editDescricao;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Tarefa();
        pessoa.setNomeDaTarefa("Fazer a atividade de programação");
        pessoa.setDataDeConclusao("23/05/2023");
        pessoa.setDescricao("Teste de tarefa");

        editNomeDaTarefa = findViewById(R.id.editTextNome_Da_Tarefa);
        editDataDeConclusao = findViewById(R.id.editTextData_De_Conclusao);
        editDescricao = findViewById(R.id.editTextDescricao);

        Log.i("ProgramacaoPOO", pessoa.toString());
    }
}
