/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.services;

/**
 *
 * @author pedro
 */
public abstract class Exception_Super extends Exception {
    String message;
    
    public Exception_Super(String message) {
        this.message = message;
    }
    public Exception_Super(){}

    @Override
    public String getMessage() {
        return message;
    }
}
