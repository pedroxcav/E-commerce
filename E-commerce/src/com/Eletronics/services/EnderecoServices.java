package com.Eletronics.services;

import com.Eletronics.model.Cliente;
import com.Eletronics.model.Endereco;
import com.Eletronics.repository.EnderecoDAO;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

public class EnderecoServices {
    
    public static boolean verificar(String ID_Endereco) {
        try {
            return EnderecoDAO.verificar(ID_Endereco);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return true;
        }
    }
    
    public static DefaultListModel trazerEnderecos(Cliente cliente) {
        try {
            return EnderecoDAO.trazerEnderecos(cliente);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static void excluir(Endereco endereco) {
        try {
            EnderecoDAO.excluir(endereco);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao excluir.");
            warning.setVisible(true);
        }
    }
    
    public static void registrar(Endereco endereco) {
        try {
            EnderecoDAO.registrar(endereco);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao salvar.");
            warning.setVisible(true);
        }
    }
}
