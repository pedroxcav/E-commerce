package com.Eletronics.services;

import com.Eletronics.model.Administrator;
import com.Eletronics.model.User;
import com.Eletronics.repository.AdministratorDAO;
import com.Eletronics.services.exceptions.Exception_Data;
import com.Eletronics.services.tools.Warning;
import javax.swing.DefaultListModel;
import java.sql.SQLException;

public class AdministratorServices {
    
    public static boolean verifyUser(User administrator) throws Exception_Data {
        try {
            if (AdministratorDAO.verifyId(administrator) && AdministratorDAO.verifyCPF(administrator))
                throw new Exception_Data("Usuário e CPF já utilizados!");
            else if (AdministratorDAO.verifyId(administrator))
                throw new Exception_Data("Usuário já utilizado!");
            else if (AdministratorDAO.verifyCPF(administrator))
                throw new Exception_Data("CPF já cadastrado!");
            return false;
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return true;
        }
    }
    
    public static Administrator getUser(String userId) {
        try {
            return AdministratorDAO.getUser(userId);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static DefaultListModel getDatabase(){
        try {
            return AdministratorDAO.getDatabase();
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static void deleteUser(Administrator administrator) {
        try {
            AdministratorDAO.delete(administrator);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao excluir.");
            warning.setVisible(true);
        }
    }
    
    public static void updateUser(Administrator administrator) throws Exception_Data {
        try {
            AdministratorDAO.update(administrator);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao atualizar.");
            warning.setVisible(true);
        }
    }
}
