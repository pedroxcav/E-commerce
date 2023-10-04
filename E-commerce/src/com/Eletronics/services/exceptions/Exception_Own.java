package com.Eletronics.services.exceptions;

public abstract class Exception_Own extends Exception {
    String message;
    
    public Exception_Own(){}

    @Override
    public String getMessage() {
        return message;
    }
}
