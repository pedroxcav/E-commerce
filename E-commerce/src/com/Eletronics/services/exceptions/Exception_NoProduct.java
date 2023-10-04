package com.Eletronics.services.exceptions;

public class Exception_NoProduct extends Exception_Own {
    public Exception_NoProduct(String message){
        super();
        this.message = message;
    }

    public Exception_NoProduct() {
        super();
    }
}
