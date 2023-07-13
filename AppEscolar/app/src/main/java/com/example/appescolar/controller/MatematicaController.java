package com.example.appescolar.controller;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.appescolar.database.EscolaDB;
import com.example.appescolar.modal.Matematica;
import com.example.appescolar.view.MainActivity;


public class MatematicaController extends EscolaDB {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";
    private EscolaDB escolaDB;

    public MatematicaController(MainActivity activity) {
        super(activity);
        preferences = activity.getSharedPreferences(NOME_PREFERENCES,0);
        listaVip = preferences.edit();
        escolaDB = new EscolaDB(activity);
    }

    @SuppressLint("LongLogTag")
    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_ControllerMatematica", "ControllerMatematica Iniciado");
        return super.toString();
    }

    private boolean existeValorPreenchido(Matematica notaMatematica) {
        return !TextUtils.isEmpty(notaMatematica.getNotaPrimeiroBimestre())
                || !TextUtils.isEmpty(notaMatematica.getNotaSegundoBimestre())
                || !TextUtils.isEmpty(notaMatematica.getNotaTerceiroBimestre())
                || !TextUtils.isEmpty(notaMatematica.getNotaQuartoBimestre());
    }

    public void salvar(Matematica notaMatematica) {
        ContentValues dados = new ContentValues();

        Log.d("MVP_MVC_controller", "Salvo: " + notaMatematica.toString());
        listaVip.putString("Nota primeiro bimestre: ", notaMatematica.getNotaPrimeiroBimestre());
        listaVip.putString("Nota segundo bimestre: ", notaMatematica.getNotaSegundoBimestre());
        listaVip.putString("Nota terceiro bimestre: ", notaMatematica.getNotaTerceiroBimestre());
        listaVip.putString("Nota quarto bimestre: ", notaMatematica.getNotaQuartoBimestre());
        listaVip.putString("Resultado Media: ", notaMatematica.getResultadoMedia());
        listaVip.apply();

        dados.put("notaMatematicaPrimeiroBimestre", notaMatematica.getNotaPrimeiroBimestre());
        dados.put("notaMatematicaSegundoBimestre", notaMatematica.getNotaSegundoBimestre());
        dados.put("notaMatematicaTerceiroBimestre", notaMatematica.getNotaTerceiroBimestre());
        dados.put("notaMatematicaQuartoBimestre", notaMatematica.getNotaQuartoBimestre());
        dados.put("resultado", notaMatematica.getResultadoMedia());

        SQLiteDatabase db = escolaDB.getWritableDatabase();
        db.insert("Escola", null, dados);
        db.close();
    }

    public void limpar (){
        listaVip.clear();
        listaVip.apply();
    }
}
