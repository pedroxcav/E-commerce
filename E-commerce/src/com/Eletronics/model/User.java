/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.model;

/**
 *
 * @author pedro
 */
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
    protected abstract boolean verifyUser(User user) throws Exception;
    
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
