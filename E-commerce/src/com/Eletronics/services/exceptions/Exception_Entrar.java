package com.Eletronics.services.exceptions;

public class Exception_Entrar extends Exception {
   // Exceção voltada ao login;
    private final String message;
    
    public Exception_Entrar (String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return message;
    } 
}
