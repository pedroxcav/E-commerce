package com.Eletronics.services;

import com.Eletronics.model.Cliente;
import com.Eletronics.model.Compra;
import com.Eletronics.model.Venda;
import com.Eletronics.repository.VendaDAO;
import com.Eletronics.services.tools.Warning;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

public class VendaServices {
    
    public static boolean verificar(String ID_Venda) {
        try {
            return VendaDAO.verificar(ID_Venda);
        } catch (SQLException ex) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return true;
        }
    }
    
    public static void salvar(Venda venda) {
        try {
            VendaDAO.salvar(venda);
        } catch (SQLException | IOException e) {
            Warning warning = new Warning("Erro ao salvar.");
            warning.setVisible(true);
        }
    }
    
    public static DefaultListModel trazerVendas(Cliente cliente) {
        try {
            Compra compra = CompraServices.trazerCompra(cliente);
            return VendaDAO.trazerVendas(compra);
        } catch (SQLException | IOException e) {
            Warning warning = new Warning("Erro ao salvar.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static DefaultListModel trazerVendas() {
        try {
            return VendaDAO.trazerVendas();
        } catch (SQLException | IOException e) {
            Warning warning = new Warning("Erro ao salvar.");
            warning.setVisible(true);
            return null;
        }
    }
}
