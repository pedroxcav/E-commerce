package com.Eletronics.model;

import com.Eletronics.services.tools.GeradorAleatorio;

public class Venda {
    private String ID_Venda;
    private String ID_Compra;
    private String ID_Endereco;
    private Produto produto;
    private int quantidade;
    private double valor;

    public Venda(String ID_Compra, String ID_Endereco, Produto produto, int quantidade) {
        this.ID_Venda = GeradorAleatorio.gerarVendaID();
        this.ID_Compra = ID_Compra;
        this.ID_Endereco = ID_Endereco;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = quantidade * produto.getValor();
    }

    public Venda(String ID_Venda, String ID_Compra, String ID_Endereco, Produto produto, int quantidade, double valor) {
        this.ID_Venda = ID_Venda;
        this.ID_Compra = ID_Compra;
        this.ID_Endereco = ID_Endereco;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getID_Venda() {
        return ID_Venda;
    }
    public String getID_Compra() {
        return ID_Compra;
    }
    public String getID_Endereco(){
        return ID_Endereco;
    }
    public Produto getProduto() {
        return produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public double getValor() {
        return valor;
    }
    public void setID_Venda(String ID_Venda) {
        this.ID_Venda = ID_Venda;
    }
    public void setID_Compra(String ID_Compra) {
        this.ID_Compra = ID_Compra;
    }
    public void setID_Endereco(String ID_Endereco) {
        this.ID_Endereco = ID_Endereco;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
}
