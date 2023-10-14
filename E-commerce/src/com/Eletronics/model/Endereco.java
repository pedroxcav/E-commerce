package com.Eletronics.model;

import com.Eletronics.services.tools.GeradorAleatorio;

public class Endereco {
    private String ID_Endereco;
    private String ID_Cliente;
    private String CEP;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;

    public Endereco(String ID_Cliente, String CEP, String rua, String numero, String bairro, String cidade) {
        this.ID_Endereco = GeradorAleatorio.gerarEnderecoID();
        this.ID_Cliente = ID_Cliente;
        this.CEP = CEP;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Endereco(String ID_Endereco, String ID_Cliente, String CEP, String rua, String numero, String bairro, String cidade) {
        this.ID_Endereco = ID_Endereco;
        this.ID_Cliente = ID_Cliente;
        this.CEP = CEP;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getID_Endereco() {
        return ID_Endereco;
    }
    public String getID_Cliente() {
        return ID_Cliente;
    }
    public String getCEP() {
        return CEP;
    }
    public String getRua() {
        return rua;
    }
    public String getNumero() {
        return numero;
    }
    public String getBairro() {
        return bairro;
    }
    public String getCidade() {
        return cidade;
    }

    public void setID_Endereco(String ID_Endereco) {
        this.ID_Endereco = ID_Endereco;
    }
    public void setID_Cliente(String ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
