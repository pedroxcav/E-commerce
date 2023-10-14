package com.Eletronics.model;

public class Celular {
    private String ID_Cliente;
    private String DDD;
    private String celular;

    public Celular(String ID_Cliente, String DDD, String celular) {
        this.ID_Cliente = ID_Cliente;
        this.DDD = DDD;
        this.celular = celular;
    }
    
    public String getID_Cliente() {
        return ID_Cliente;
    }
    public String getDDD() {
        return DDD;
    }
    public String getCelular() {
        return celular;
    }
    public void setID_Cliente(String ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }
    public void setDDD(String DDD) {
        this.DDD = DDD;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
}
