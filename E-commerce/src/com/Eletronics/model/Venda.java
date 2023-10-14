package com.Eletronics.model;

import com.Eletronics.services.tools.GeradorAleatorio;

public class Venda {
    private String ID_Venda;
    private String ID_carrinho;
    private Produto produto;
    private int quantidade;
    private double valor;

    public Venda(String ID_carrinho, Produto produto, int quantidade) {
        this.ID_Venda = GeradorAleatorio.gerarVendaID();
        this.ID_carrinho = ID_carrinho;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = quantidade * produto.getValor();
    }

    public Venda(String ID_Venda, String ID_carrinho, Produto produto, int quantidade) {
        this.ID_Venda = ID_Venda;
        this.ID_carrinho = ID_carrinho;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = quantidade * produto.getValor();
    }

    public String getID_Venda() {
        return ID_Venda;
    }
    public String getID_carrinho() {
        return ID_carrinho;
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
    public void setID_carrinho(String ID_carrinho) {
        this.ID_carrinho = ID_carrinho;
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
