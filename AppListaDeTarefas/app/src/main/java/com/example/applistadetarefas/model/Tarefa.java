package com.example.applistadetarefas.model;

public class Tarefa {
    private String nomeDaTarefa;
    private String dataDeConclusao;
    private String descricao;

    public Tarefa() {

    }

    public Tarefa(String nomeDaTarefa, String dataDeConclusao, String descricao) {
        this.nomeDaTarefa = nomeDaTarefa;
        this.dataDeConclusao = dataDeConclusao;
        this.descricao = descricao;
    }

    public String getNomeDaTarefa() {
        return nomeDaTarefa;
    }

    public void setNomeDaTarefa(String nomeDaTarefa) {
        this.nomeDaTarefa = nomeDaTarefa;
    }

    public String getDataDeConclusao() {
        return dataDeConclusao;
    }

    public void setDataDeConclusao(String dataDeConclusaoDaTarefa) {
        this.dataDeConclusao = dataDeConclusaoDaTarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "nomeDaTarefa='" + nomeDaTarefa + '\'' +
                ", dataDeConclusaoDaTarefa='" + dataDeConclusao + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
