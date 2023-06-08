package dev.android.santos.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import dev.android.santos.applistacurso.model.Curso;
import dev.android.santos.applistacurso.view.MainActivity;

public class CursoController {
    private List<Curso> listaCursos;

    public CursoController(MainActivity mainActivity) {
        listaCursos = new ArrayList<>();
        lista();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "CursoController Iniciada...");
        return super.toString();
    }

    private void lista() {
        listaCursos.add(new Curso("Curso 1"));
        listaCursos.add(new Curso("Curso 2"));
        listaCursos.add(new Curso("Curso 3"));
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }
}
