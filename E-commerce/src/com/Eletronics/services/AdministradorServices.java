package com.Eletronics.services;

import com.Eletronics.model.Administrador;
import com.Eletronics.model.Usuario;
import com.Eletronics.repository.AdministradorDAO;
import com.Eletronics.services.exceptions.Exception_Cadastro;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

public class AdministradorServices {
    public static void verificar (Usuario administrador) throws Exception_Cadastro {
        try {
            if (AdministradorDAO.verificarID(administrador) && AdministradorDAO.verificarCPF(administrador))
                throw new Exception_Cadastro("Usuário e CPF já usados.");
            else if (AdministradorDAO.verificarID(administrador)) 
                throw new Exception_Cadastro("Usuário já utilizado.");
            else if (AdministradorDAO.verificarCPF(administrador)) 
                throw new Exception_Cadastro("CPF já utilizado.");
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
        }
    }
    
    public static DefaultListModel trazerAdministradores() {
        try {
            return AdministradorDAO.trazerAdministradores("");
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static DefaultListModel trazerAdministradores(String text) {
        try {
            return AdministradorDAO.trazerAdministradores(text);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static Administrador trazerAdministrador(String ID_Administrador) {
        try {
            return AdministradorDAO.trazerAdministrador(ID_Administrador);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;        
        }
    }
    
    public static void excluir(Administrador administrador) {
        try {
            AdministradorDAO.excluir(administrador);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao excluir.");
            warning.setVisible(true);
        }
    }
    
    public static void atualizar(Administrador administrador) throws Exception_Cadastro {
        try {
            verificarAtualizacao(administrador);
            AdministradorDAO.atualizar(administrador);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao atualizar.");
            warning.setVisible(true);
        }
    }
    
    private static void verificarAtualizacao(Administrador administrador) throws Exception_Cadastro {
        try {
           if (AdministradorDAO.verificarAtualizacao(administrador))
               throw new Exception_Cadastro("Usuário já utilizado.");
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
        }
    }
}
