package com.Eletronics.services;

import com.Eletronics.model.Produto;
import com.Eletronics.repository.ProdutoDAO;
import com.Eletronics.services.tools.Warning;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

public class ProdutoServices {
    
    public static boolean verificar(String ID_Produto) {
        try {
            return ProdutoDAO.verificar(ID_Produto);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return true;
        }
    }
    
    public static void registrar(Produto produto) {
        try {
            ProdutoDAO.registrar(produto);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
        } catch (IOException e) {
            Warning warning = new Warning("Seleciona uma imagem png.");
            warning.setVisible(true);
        }
    }
    
    public static DefaultListModel trazerProdutos() {
        try {
            return ProdutoDAO.trazerProdutos("");
        } catch (SQLException | IOException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static DefaultListModel trazerProdutos(String text) {
        try {
            return ProdutoDAO.trazerProdutos(text);
        } catch (SQLException | IOException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static Produto trazerProduto(String ID_Produto) {
        try {
            return ProdutoDAO.trazerProduto(ID_Produto);
        } catch (SQLException | IOException ex) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static void atualizar(Produto produto) {
        try {
            ProdutoDAO.atualizar(produto);
        } catch (SQLException ex) {
            Warning warning = new Warning("Erro descinhecido.");
            warning.setVisible(true);
        } catch (IOException ex) {
            Warning warning = new Warning("Selecione uma imagem png.");
            warning.setVisible(true);
        }
    }
    
    public static void excluir(Produto produto) {
        try {
            ProdutoDAO.excluir(produto);
        } catch (SQLException ex) {
            Warning warning = new Warning("Erro ao excluir.");
            warning.setVisible(true);
        }
    }
}
