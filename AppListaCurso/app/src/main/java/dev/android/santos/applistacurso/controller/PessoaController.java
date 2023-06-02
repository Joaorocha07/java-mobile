package dev.android.santos.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import dev.android.santos.applistacurso.model.Pessoa;
import dev.android.santos.applistacurso.view.MainActivity;

public class PessoaController {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciada...");
        return super.toString();
    }

    public void salvar(Pessoa outraPessoa) {
        Log.d("MVC_Controller", "Salvo: " + outraPessoa.toString());
        listaVip.putString("primeiroNome", outraPessoa.getPrimeiroNome());
        listaVip.putString("sobreNome", outraPessoa.getSegundoNome());
        listaVip.putString("nomeCurso", outraPessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", outraPessoa.getTelefoneContato());
        listaVip.apply();
    }

    public Pessoa procurar(Pessoa outraPessoa){
        outraPessoa.setPrimeiroNome(preferences.getString("primeiroNome",""));
        outraPessoa.setSegundoNome(preferences.getString("sobreNome", ""));
        outraPessoa.setCursoDesejado(preferences.getString("nomeCurso", ""));
        outraPessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));
        return outraPessoa;
    }

    public void limpar(){
        listaVip.clear();
        listaVip.apply();
    }
}
