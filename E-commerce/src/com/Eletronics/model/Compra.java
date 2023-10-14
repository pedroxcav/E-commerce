package com.Eletronics.model;

public class Compra {
    private String ID_Compra;
    private String ID_Cliente;

    public Compra(String ID_Compra, String ID_Cliente) {
        this.ID_Compra = ID_Compra;
        this.ID_Cliente = ID_Cliente;
    }

    public String getID_Compra() {
        return ID_Compra;
    }
    public String getID_Cliente() {
        return ID_Cliente;
    }
    public void setID_Compra(String ID_Compra) {
        this.ID_Compra = ID_Compra;
    }
    public void setID_Cliente(String ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }
}
