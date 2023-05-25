package com.example.applistadetarefas.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applistadetarefas.R;
import com.example.applistadetarefas.model.Tarefa;

public class MainActivity extends AppCompatActivity {

    Tarefa novaTarefa;

    EditText editNomeDaTarefa;
    EditText editDescricao;
    EditText editDataDeConclusao;

    Button editBtnLimpar;
    Button editBtnSalvar;
    Button editBtnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        novaTarefa = new Tarefa();

        editNomeDaTarefa = findViewById(R.id.edit_nome_da_tarefa);
        editDescricao = findViewById(R.id.edit_descricao);
        editDataDeConclusao = findViewById(R.id.edit_data_de_conclusao);

        editBtnLimpar = findViewById(R.id.btn_limpar);
        editBtnSalvar = findViewById(R.id.btn_salvar);
        editBtnFinalizar = findViewById(R.id.btn_finalizar);

        editBtnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNomeDaTarefa.setText("");
                editDescricao.setText("");
                editDataDeConclusao.setText("");
                Toast.makeText(MainActivity.this,"Limpo com sucesso", Toast.LENGTH_LONG).show();
            }
        });

        editBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novaTarefa.setNomeDaTarefa(editNomeDaTarefa.getText().toString());
                novaTarefa.setDescricao(editDescricao.getText().toString());
                novaTarefa.setDataDeConclusao(editDataDeConclusao.getText().toString());
                Toast.makeText(MainActivity.this,"Salvo com sucesso",Toast.LENGTH_LONG).show();
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
