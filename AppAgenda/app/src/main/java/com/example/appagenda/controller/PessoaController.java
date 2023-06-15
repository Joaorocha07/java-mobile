package com.example.appagenda.controller;

import com.example.appagenda.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaController {
    private List listaAgenda;

    public PessoaController() {
        listaAgenda = new ArrayList<>();
        lista();
    }

    public List<Pessoa> getListaCursos() {
        return listaAgenda;
    }

    private List lista() {
        listaAgenda = new ArrayList<Pessoa>();
        listaAgenda.add(new Pessoa("Aniversario Kah"));
        listaAgenda.add(new Pessoa("Feira de Ciências"));
        listaAgenda.add(new Pessoa("Treino"));
        listaAgenda.add(new Pessoa("Festa Universitaria"));
        listaAgenda.add(new Pessoa("Chá De Bebê"));
        listaAgenda.add(new Pessoa("Campeonato"));
        return listaAgenda;
    }

    public ArrayList<String> dadosSpinner() {
        ArrayList<String> dados = new ArrayList<>();
        for (int i = 0; i < getListaCursos().size(); i++) {
            Pessoa objeto = (Pessoa) getListaCursos().get(i);
            dados.add(objeto.getAgendaDesejada());
        }
        return dados;
    }
}
