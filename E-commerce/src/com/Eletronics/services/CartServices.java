package com.Eletronics.services;

import com.Eletronics.model.Item;
import com.Eletronics.repository.CartDAO;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class CartServices {
    
    public static DefaultListModel getCart(String userId){
        try {
            DefaultListModel listModel = CartDAO.getDatabase(userId);
            return listModel;
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao consultar dados.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static double getTotalPrice(JList cartList){
        double totalPrice = 0;
        DefaultListModel listModel = (DefaultListModel) cartList.getModel();
        for (int i=0; i < listModel.getSize(); i++){
            Item item = (Item) listModel.getElementAt(i);
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
