package dev.android.santos.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import dev.android.santos.applistacurso.R;
import dev.android.santos.applistacurso.controller.CursoController;
import dev.android.santos.applistacurso.controller.PessoaController;
import dev.android.santos.applistacurso.model.Pessoa;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;
    CursoController CursoController;

    Pessoa outraPessoa;
    List<String> nomesDoCurso;

    EditText edit_PrimeiroNome;
    EditText edit_SegundoNome;
    EditText edit_CursoDesejado;
    EditText edit_TelefoneContato;

    Button btn_Salvar;
    Button btn_Limpar;
    Button btn_Finalizar;

    Spinner edit_Spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CursoController cursoController = new CursoController();

        nomesDoCurso = cursoController.dadosSpinner();

        controller = new PessoaController(MainActivity.this);

        controller.toString();

        outraPessoa = new Pessoa();
        // controller.procurar(outraPessoa);

        edit_PrimeiroNome = findViewById(R.id.edit_PrimeiroNome);
        edit_SegundoNome = findViewById(R.id.edit_SegundoNome);
        edit_CursoDesejado = findViewById(R.id.edit_CursoDesejado);
        edit_TelefoneContato = findViewById(R.id.edit_TelefoneContato);

        edit_PrimeiroNome.setText(outraPessoa.getPrimeiroNome());
        edit_SegundoNome.setText(outraPessoa.getSegundoNome());
        edit_CursoDesejado.setText(outraPessoa.getCursoDesejado());
        edit_TelefoneContato.setText(outraPessoa.getTelefoneContato());

        btn_Limpar = findViewById(R.id.btn_Limpar);
        btn_Salvar = findViewById(R.id.btn_Salvar);
        btn_Finalizar = findViewById(R.id.btn_Finalizar);

        edit_Spinner = findViewById(R.id.txtListaSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cursoController.dadosSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        edit_Spinner.setAdapter(adapter);

        btn_Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Informacoes Limpadas", Toast.LENGTH_LONG).show();
                edit_PrimeiroNome.setText("");
                edit_SegundoNome.setText("");
                edit_CursoDesejado.setText("");
                edit_TelefoneContato.setText("");
            }
        });

        btn_Finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte sempre!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btn_Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String primeiroNome = edit_PrimeiroNome.getText().toString();
                String segundoNome = edit_SegundoNome.getText().toString();
                String cursoDesejado = edit_CursoDesejado.getText().toString();
                String telefoneContato = edit_TelefoneContato.getText().toString();

                Pessoa curso = new Pessoa();
                curso.setPrimeiroNome(primeiroNome);
                curso.setSegundoNome(segundoNome);
                curso.setCursoDesejado(cursoDesejado);
                curso.setTelefoneContato(telefoneContato);

                controller.salvar(curso);

                Toast.makeText(MainActivity.this, "Dados salvos com sucesso" + outraPessoa.toString(), Toast.LENGTH_LONG).show();
            }
        });

        Log.i("POOAndroid", outraPessoa.toString());
    }
}