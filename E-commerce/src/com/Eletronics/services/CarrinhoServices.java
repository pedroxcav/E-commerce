package com.Eletronics.services;

import com.Eletronics.model.Carrinho;
import com.Eletronics.model.Cliente;
import com.Eletronics.model.Pedido;
import com.Eletronics.repository.CarrinhoDAO;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class CarrinhoServices {
    
    public static boolean verificar(String ID_Carrinho) {
        try {
            return CarrinhoDAO.verificar(ID_Carrinho);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return true;
        }
    }
    
    public static void regitsrar(Carrinho carrinho) {
        try {
            CarrinhoDAO.registar(carrinho);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
        }
    }
    
    public static Carrinho trazerCarrinho(Cliente cliente) {
        try {
            return CarrinhoDAO.trazerCarrinho(cliente);
        } catch (SQLException ex) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static double definirValortotal(JList Campo_Lista) {
        double totalPrice = 0;
        DefaultListModel listModel = (DefaultListModel) Campo_Lista.getModel();
        for (int i=0; i < listModel.getSize(); i++) {
            Pedido pedido = (Pedido) listModel.getElementAt(i);
            totalPrice += pedido.getValor();
        }
        return totalPrice;
    }
}
