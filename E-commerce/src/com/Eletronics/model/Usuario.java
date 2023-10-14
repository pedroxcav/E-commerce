package com.Eletronics.model;

public abstract class Usuario {
    protected String ID;
    protected String nome;
    protected String CPF;
    protected String senha;
    
    public Usuario (String ID, String nome, String CPF, String senha) {
        this.ID = ID;
        this.nome = nome;
        this.CPF = CPF;
        this.senha = senha;
    }
    
    public Usuario() {};
    
    public abstract void registar(Usuario usuario);
    public abstract boolean entrar(String ID, String senha);

    public String getNome() {
        return nome;
    }
    public String getID() {
        return ID;
    }
    public String getCPF() {
        return CPF;
    }
    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
