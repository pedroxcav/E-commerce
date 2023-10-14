package com.Eletronics.services;

import com.Eletronics.model.Carrinho;
import com.Eletronics.model.Cliente;
import com.Eletronics.model.Pedido;
import com.Eletronics.repository.PedidoDAO;
import com.Eletronics.services.tools.Warning;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

public class PedidoServices {
    
    public static boolean verificar(String ID_Pedido) {
        try {
            return PedidoDAO.verificar(ID_Pedido);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return true;
        }
    }
    
    public static void salvar(Pedido pedido) {
        try {
            PedidoDAO.salvar(pedido);
        } catch (SQLException | IOException ex) {
            Warning warning = new Warning("Erro ao salvar.");
            warning.setVisible(true);
        }
    }
    
    public static DefaultListModel trazerPedidos(Cliente cliente) {
        try {
            Carrinho carrinho = CarrinhoServices.trazerCarrinho(cliente);
            return PedidoDAO.trazerPedidos(carrinho);
        } catch (SQLException | IOException ex) {
            Warning warning = new Warning("Erro ao salvar.");
            warning.setVisible(true);
            return null;
        }
    }
    
    /*
    private static Pedido trazerPedido(String ID_Pedido) {
        try {
            return PedidoDAO.trazerPedido(ID_Pedido);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    */
    
    public static void excluir(Pedido pedido) {
        try {
            PedidoDAO.excluir(pedido);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao excluir.");
            warning.setVisible(true);        
        }
    }
    
    public static void atualizar(Pedido pedido) {
        try {
            PedidoDAO.atualizar(pedido);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao atualizar.");
            warning.setVisible(true); 
        }
    }
}
