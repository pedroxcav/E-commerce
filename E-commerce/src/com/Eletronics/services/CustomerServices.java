package com.Eletronics.services;

import com.Eletronics.model.Customer;
import com.Eletronics.model.Item;
import com.Eletronics.model.Product;
import com.Eletronics.model.User;
import com.Eletronics.repository.CartDAO;
import com.Eletronics.repository.CustomerDAO;
import com.Eletronics.services.exceptions.Exception_Data;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

public class CustomerServices {
    
    public static void addToCart(Customer customer, String productId, int quantity){
        try {
            Product product = ProductServices.getProduct(productId);
            Item item = new Item(customer.getUserId(), product, quantity);
            CartDAO.addToDatabase(item);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao adicionar.");
            warning.setVisible(true);
        }
    }
    
    public static String selectItem(JList cartList, JLabel nameField){
        if (cartList.getModel().getSize() != 0) {
            DefaultListModel listModel = (DefaultListModel) cartList.getModel();
            Item item = (Item) listModel.get(cartList.getSelectedIndex());
            String name = item.getProduct().getName().toUpperCase();
            return name;
        }
        return null;
    }
    
    public static boolean verifyUser(User customer) throws Exception_Data {
        try {
            if (CustomerDAO.verifyId(customer) && CustomerDAO.verifyCPF(customer))
                throw new Exception_Data("Usuário e CPF já utilizados!");
            else if (CustomerDAO.verifyId(customer))
                throw new Exception_Data("Usuário já utilizado!");
            else if (CustomerDAO.verifyCPF(customer))
                throw new Exception_Data("CPF já cadastrado!");
            return false;
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return true;
        }
    }
    
    public static Customer getUser(String customerId) {
        try {
            return CustomerDAO.getUser(customerId);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static DefaultListModel searchCustomerDatabase(String text){
        try {
            return CustomerDAO.getDatabase(text);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static DefaultListModel searchCustomerDatabase(){
        try {
            return CustomerDAO.getDatabase("");
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static void deleteUser(Customer customer){
        try {
            CustomerDAO.delete(customer);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao excluir.");
            warning.setVisible(true);
        }
    }
    
    public static void updateUser(Customer customer) throws Exception_Data {
        try {
            CustomerDAO.update(customer);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao atualizar.");
            warning.setVisible(true);
        }
    }
}
