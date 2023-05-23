package com.example.atividade.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.atividade.R;
import com.example.atividade.model.PessoaModel;

public class MainActiviyty extends AppCompatActivity {

    PessoaModel pessoa;
    PessoaModel outraPessoa;

    String dadosPessoa;
    String dadosOutraPessoa;

    EditText textPrimeiroNome;
    EditText textNomeDoCurso;
    EditText textSobrenome;
    EditText textTelefone;

    Button textBtnSalvar;
    Button textBtnLimpar;
    Button textBtnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new PessoaModel();
        pessoa.setNome("João Victor");
        pessoa.setSobrenome("Rocha Santos");
        pessoa.setNomeDoCurso("Senac - Técnico em Desenvolvimento em Sistemas");
        pessoa.setTelefone(99714023);

        outraPessoa = new PessoaModel();
        pessoa.setNome("Pedro Henrrique");
        pessoa.setSobrenome("Silva Pereira");
        pessoa.setNomeDoCurso("Senac - Técnico em Desenvolvimento em Sistemas");
        pessoa.setTelefone(99654598);

        textPrimeiroNome = findViewById(R.id.text_primeiro_nome);
        textNomeDoCurso = findViewById(R.id.text_nome_do_curso);
        textSobrenome = findViewById(R.id.text_sobrenome);
        textTelefone = findViewById(R.id.text_telefone);

        textBtnSalvar = findViewById(R.id.text_btn_salvar);
        textBtnLimpar = findViewById(R.id.text_btn_limpar);
        textBtnFinalizar = findViewById(R.id.text_btn_finalizar);

        textPrimeiroNome.setText(pessoa.getNome());
        textNomeDoCurso.setText(pessoa.getNomeDoCurso());
        textSobrenome.setText(pessoa.getSobrenome());
        textTelefone.setText(pessoa.getTelefone());

        dadosPessoa = "Primeiro Nome: ";
        dadosPessoa += pessoa.getNome();
        dadosPessoa += "Sobrenome: ";
        dadosPessoa += pessoa.getSobrenome();
        dadosPessoa += "Curso Desejado: ";
        dadosPessoa += pessoa.getNomeDoCurso();
        dadosPessoa += "Telefone Para Contato: ";
        dadosPessoa += pessoa.getTelefone();

        dadosOutraPessoa += "Primeiro Nome: ";
        dadosOutraPessoa += pessoa.getNome();
        dadosOutraPessoa += "Sobrenome: ";
        dadosOutraPessoa += pessoa.getSobrenome();
        dadosOutraPessoa += "Curso Desejado: ";
        dadosOutraPessoa += pessoa.getNomeDoCurso();
        dadosOutraPessoa += "Telefone Para Contato: ";
        dadosOutraPessoa += pessoa.getTelefone();

        Log.i("POOAndroid", pessoa.toString());
        Log.i("POOAndroid", outraPessoa.toString());
    }
}
