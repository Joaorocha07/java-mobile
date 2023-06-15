package dev.android.santos.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import dev.android.santos.applistacurso.model.Curso;

public class CursoController {
    private List listaCursos;

    public CursoController() {
        listaCursos = new ArrayList<>();
        lista();
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    private List lista() {
        listaCursos = new ArrayList<Curso>();
        listaCursos.add(new Curso("Informatica"));
        listaCursos.add(new Curso("Biologia"));
        listaCursos.add(new Curso("Mecanica"));
        listaCursos.add(new Curso("Briga de Galo"));
        listaCursos.add(new Curso("Agiotagem"));
        listaCursos.add(new Curso("Hacker"));
        return listaCursos;
    }

    public ArrayList<String> dadosSpinner() {
        ArrayList<String> dados = new ArrayList<>();
        for (int i = 0; i < getListaCursos().size(); i++) {
            Curso objeto = (Curso) getListaCursos().get(i);
            dados.add(objeto.getCursoDesejado());
        }
        return dados;
    }
}
