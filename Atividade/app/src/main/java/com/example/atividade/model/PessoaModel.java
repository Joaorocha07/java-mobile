package com.example.atividade.model;

public class PessoaModel {
    private String nome;
    private String sobrenome;
    private String nomeDoCurso;
    private int telefone;

    public PessoaModel() {

    }

    public PessoaModel(String nome, String sobrenome, String nomeDoCurso, int telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nomeDoCurso = nomeDoCurso;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNomeDoCurso() {
        return nomeDoCurso;
    }

    public void setNomeDoCurso(String nomeDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "PessoaModel{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", nomeDoCurso='" + nomeDoCurso + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}
