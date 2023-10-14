
package com.Eletronics.services.exceptions;

public class Exception_Cadastro extends Exception {
    // Exceção voltada ao cadastro;
    private final String message;
    
    public Exception_Cadastro (String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
}
