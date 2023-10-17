package com.Eletronics.services;

import com.Eletronics.model.Cliente;
import com.Eletronics.model.Usuario;
import com.Eletronics.repository.ClienteDAO;
import com.Eletronics.services.exceptions.Exception_Cadastro;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

public class ClienteServices {
    
    public static void verificar (Usuario cliente) throws Exception_Cadastro {
        try {
            if (ClienteDAO.verificarID(cliente) && ClienteDAO.verificarCPF(cliente))
                throw new Exception_Cadastro("Usuário e CPF já usados.");
            else if (ClienteDAO.verificarID(cliente))
                throw new Exception_Cadastro("Usuário já utilizado.");
            else if (ClienteDAO.verificarCPF(cliente))
                throw new Exception_Cadastro("CPF já utilizado.");
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
        }
    }
    
    public static void verificarID (Usuario cliente) throws Exception_Cadastro {
        try {
           if (ClienteDAO.verificarID(cliente)) 
               throw new Exception_Cadastro("Usuário já utilizado.");
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
        }
    }
    
    public static DefaultListModel trazerClientes() {
        try {
            return ClienteDAO.trazerClientes("");
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static DefaultListModel trazerClientes(String text) {
        try {
            return ClienteDAO.trazerClientes(text);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static Cliente trazerCliente(String ID_Cliente) {
        try {
            return ClienteDAO.trazerCliente(ID_Cliente);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;        
        }
    }
    
    public static void excluir(Cliente cliente) {
        try {
            ClienteDAO.excluir(cliente);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao excluir.");
            warning.setVisible(true);
        }
    }
    
    public static void atualizar(Cliente cliente) throws Exception_Cadastro {
        try {
            verificarAtualizacao(cliente);
            ClienteDAO.atualizar(cliente);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao atualizar.");
            warning.setVisible(true);
        }
    }
    
    private static void verificarAtualizacao(Cliente cliente) throws Exception_Cadastro {
        try {
           if (ClienteDAO.verificarAtualizacao(cliente))
               throw new Exception_Cadastro("Usuário já utilizado.");
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
        }
    }
}
