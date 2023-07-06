package devandroid.maruzam.appgaseta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.maruzam.appgaseta.model.Pessoa;
import devandroid.maruzam.appgaseta.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {

        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

    }
    @NonNull
    @Override
    public String toString() {


        Log.d("MVC_Controller", "Controller Iniciada...");

        return super.toString();

    }

    public void salvar(Pessoa pessoa) {
        Log.d("MVC_Controller", "Salvo: " + pessoa.toString());

        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome", pessoa.getSobreNome());
        listaVip.putString("nomeCurso", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
        listaVip.apply();//10

    }

    public Pessoa buscar(Pessoa Pessoa) {

        Pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        Pessoa.setSobreNome(preferences.getString("sobreNome", "NA"));
        Pessoa.setCursoDesejado(preferences.getString("nomeCurso", "NA"));
        Pessoa.setTelefoneContato(preferences.getString("telefoneContato", "NA"));
        return Pessoa;//13

    }

    public void limpar() {

        listaVip.clear();
        listaVip.apply();

    }
}