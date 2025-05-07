package com.example.app04.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String perfil;

    private List<Tarefa> tarefas = new ArrayList<>();

    public Usuario() {}

    public Usuario(String nome, String login, String senha, String email, String perfil) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.perfil = perfil;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPerfil() { return perfil; }
    public void setPerfil(String perfil) { this.perfil = perfil; }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }
}