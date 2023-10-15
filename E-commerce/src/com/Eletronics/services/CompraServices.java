package com.Eletronics.services;

import com.Eletronics.model.Cliente;
import com.Eletronics.model.Compra;
import com.Eletronics.model.Endereco;
import com.Eletronics.model.Pedido;
import com.Eletronics.model.Venda;
import com.Eletronics.repository.CompraDAO;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class CompraServices {
    
    public static boolean verificar(String ID_Compra) {
        try {
            return CompraDAO.verificar(ID_Compra);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return true;
        }
    }
    
    public static void regitsrar(Compra compra) {
        try {
            CompraDAO.registar(compra);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
        }
    }
    
    public static Compra trazerCompra(Cliente cliente) {
        try {
            return CompraDAO.trazerCompra(cliente);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static void comprar(Cliente cliente, Endereco endereco) {
        DefaultListModel pedidos = PedidoServices.trazerPedidos(cliente);
        for (int i=0; i<pedidos.size(); i++) {
            Compra compra = CompraServices.trazerCompra(cliente);
            Pedido pedido = (Pedido) pedidos.getElementAt(i);
            Venda venda = new Venda(compra.getID_Compra(), endereco.getID_Endereco(), pedido.getProduto(), pedido.getQuantidade());
            VendaServices.salvar(venda);
            PedidoServices.excluir(pedido);
        }
    }
    
    public static double definirValortotal(JList Campo_Lista) {
        double totalPrice = 0;
        DefaultListModel listModel = (DefaultListModel) Campo_Lista.getModel();
        for (int i=0; i < listModel.getSize(); i++) {
            Venda venda = (Venda) listModel.getElementAt(i);
            totalPrice += venda.getValor();
        }
        return totalPrice;
    }
}
