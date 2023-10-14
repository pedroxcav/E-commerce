package com.Eletronics.model;

public class Carrinho {
    private String ID_Carrinho;
    private String ID_Cliente;

    public Carrinho(String ID_Carrinho, String ID_Cliente) {
        this.ID_Carrinho = ID_Carrinho;
        this.ID_Cliente = ID_Cliente;
    }

    public String getID_Carrinho() {
        return ID_Carrinho;
    }
    public String getID_Cliente() {
        return ID_Cliente;
    }
    public void setID_Carrinho(String ID_Carrinho) {
        this.ID_Carrinho = ID_Carrinho;
    }
    public void setID_Cliente(String ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }
    
}
