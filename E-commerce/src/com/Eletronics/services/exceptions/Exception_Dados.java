package com.Eletronics.services.exceptions;

public class Exception_Dados extends Exception {
    // Exceção voltada aos dados informados;
    private final String message;
    
    public Exception_Dados (String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
}
