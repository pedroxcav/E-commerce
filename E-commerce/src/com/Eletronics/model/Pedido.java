package com.Eletronics.model;

import com.Eletronics.services.tools.GeradorAleatorio;

public class Pedido {
    private String ID_Pedido;
    private String ID_carrinho;
    private Produto produto;
    private int quantidade;
    private double valor;

    public Pedido(String ID_carrinho, Produto produto, int quantidade) {
        this.ID_Pedido = GeradorAleatorio.gerarPedidoID();
        this.ID_carrinho = ID_carrinho;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = quantidade * produto.getValor();
    }

    public Pedido(String ID_Pedido, String ID_carrinho, Produto produto, int quantidade) {
        this.ID_Pedido = ID_Pedido;
        this.ID_carrinho = ID_carrinho;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = quantidade * produto.getValor();
    }

    public String getID_Pedido() {
        return ID_Pedido;
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
    public void setID_Pedido(String ID_Pedido) {
        this.ID_Pedido = ID_Pedido;
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

