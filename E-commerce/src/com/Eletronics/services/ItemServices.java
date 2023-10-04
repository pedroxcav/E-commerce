package com.Eletronics.services;

import com.Eletronics.model.Item;
import com.Eletronics.repository.ItemDAO;
import com.Eletronics.services.exceptions.Exception_Data;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;

public class ItemServices {
    
    public static void updateItem(Item item){
        try {
            ItemDAO.update(item);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao atualizar!");
            warning.setVisible(true);
        }
    }
    
    public static void deleteItem(Item item){
        try {
            ItemDAO.delete(item);
        } catch (SQLException e) {
            Warning warning = new Warning("[ERRO]");
            warning.setVisible(true);
        }
    }
    
    public static boolean verifyItem(String id){
        try {
            ItemDAO.verify(id);
            return false;
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return true;
        } catch (Exception_Data e) {
            return true;
        }
    }
}
