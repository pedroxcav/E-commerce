package com.Eletronics.model;

import java.awt.image.BufferedImage;

public class Produto {
    private String ID_Produto;
    private String nome;
    private String descricao;
    private double valor;
    private BufferedImage imagem;

    public Produto(String ID_Produto, String nome, String descricao, double valor, BufferedImage imagem) {
        this.ID_Produto = ID_Produto;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.imagem = imagem;
    }

    public String getID_Produto() {
        return ID_Produto;
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public double getValor() {
        return valor;
    }
    public BufferedImage getImagem() {
        return imagem;
    }
    public void setID_Produto(String ID_Produto) {
        this.ID_Produto = ID_Produto;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setImagem(BufferedImage imagem) {
        this.imagem = imagem;
    }
}
