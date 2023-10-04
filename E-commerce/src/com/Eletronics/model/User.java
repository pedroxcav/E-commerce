package com.Eletronics.model;

public abstract class User {
    private String name;
    private String userId;
    private String CPF;
    private String password;

    protected User(String name, String userId, String CPF, String password) {
        this.name = name;
        this.userId = userId;
        this.CPF = CPF;
        this.password = password;
    }
    protected User(){}
    
    
    public abstract void registerUser(User user);
    public abstract boolean logInto(String userId, String password);
    
    public String getName() {
        return name;
    }
    public String getUserId() {
        return userId;
    }
    public String getCPF() {
        return CPF;
    }
    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
