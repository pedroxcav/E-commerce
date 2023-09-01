/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.model;

/**
 *
 * @author pedro
 */
public class Administrator extends User {

    public Administrator(String name, String userId, String CPF, String password) {
        super(name, userId, CPF, password);
    }
    
    @Override
    public void registerUser(User administrator) {
        
    }
    @Override
    public void logInto(User administrator) {
        
    }
    @Override
    protected boolean verifyUser(User administrator) {
        return false;
    }
}
