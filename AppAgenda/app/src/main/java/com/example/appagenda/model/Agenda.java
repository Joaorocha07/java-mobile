package com.example.appagenda.model;

public class Agenda {
    private String titulo;
    private String horario;
    private String local;

    public Agenda() {

    }

    public Agenda(String titulo, String horario, String local) {
        this.titulo = titulo;
        this.horario = horario;
        this.local = local;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getHorario(String s) {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLocal(String s) {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
