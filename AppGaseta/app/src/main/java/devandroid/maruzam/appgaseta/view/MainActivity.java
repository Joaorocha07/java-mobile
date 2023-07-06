package devandroid.maruzam.appgaseta.view;

import static devandroid.maruzam.appgaseta.R.layout.activity_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.maruzam.appgaseta.R;
import devandroid.maruzam.appgaseta.controller.CursoController;
import devandroid.maruzam.appgaseta.controller.PessoaController;
import devandroid.maruzam.appgaseta.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;
    CursoController cursoController;
    Pessoa Pessoa;
    List<String> nomesDosCursos;


    EditText editPrimeiroNome;
    EditText editSobreNome;
    EditText editCursoDesejado;
    EditText editTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

   Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_spinner);

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        cursoController = new CursoController();
        nomesDosCursos = cursoController.dadosSpinner();

        Pessoa = new Pessoa();
        controller.buscar(Pessoa);

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobrenome);
        editCursoDesejado = findViewById(R.id.editCursoDesejado);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);
        spinner = findViewById(R.id.spinner);

        editPrimeiroNome.setText(Pessoa.getPrimeiroNome());
        editSobreNome.setText(Pessoa.getSobreNome());
        editCursoDesejado.setText(Pessoa.getCursoDesejado());
        editTelefoneContato.setText(Pessoa.getTelefoneContato());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cursoController.dadosSpinner() );
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobreNome.setText("");
                editCursoDesejado.setText("");
                editTelefoneContato.setText("");

                controller.limpar();

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                Pessoa.setSobreNome(editSobreNome.getText().toString());
                Pessoa.setCursoDesejado(editCursoDesejado.getText().toString());
                Pessoa.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Dados Salvos: " + Pessoa.toString(), Toast.LENGTH_LONG).show();

                controller.salvar(Pessoa);
            }
        });

        Log.i("POOAndroid", Pessoa.toString());


    }
}