package com.Eletronics.services;

import com.Eletronics.model.Customer;
import com.Eletronics.model.Product;
import com.Eletronics.repository.ProductDAO;
import com.Eletronics.services.exceptions.Exception_Data;
import com.Eletronics.view.CustomerProduct;
import com.Eletronics.services.tools.Warning;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class ProductServices {
    private final JLabel nameField;
    private final JLabel idField;
    private final JLabel descriptionField;
    private final JLabel priceField;
    private final JLabel quantityField;
    private final JLabel imageField;

    public ProductServices(JLabel nameField, JLabel idField, JLabel descriptionField, JLabel priceField, JLabel quantityField, JLabel imageField) {
        this.nameField = nameField;
        this.idField = idField;
        this.descriptionField = descriptionField;
        this.priceField = priceField;
        this.quantityField = quantityField;
        this.imageField = imageField;
    }
    
    public static boolean verifyProduct(String id) {
        try {
            return ProductDAO.verify(id);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return true;
        } catch (Exception_Data e) {
            return true;
        }
    }
    
    public static DefaultListModel getDatabase(String text) {
        try {
            return ProductDAO.getDatabase(text);
        } catch (SQLException | IOException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static DefaultListModel getDatabase() {
        try {
            return ProductDAO.getDatabase("");
        } catch (SQLException | IOException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static void showProduct(JFrame screen, JList list, Customer customer){
        DefaultListModel listModel = (DefaultListModel) list.getModel();
        Product product = (Product) listModel.getElementAt(list.getSelectedIndex());
        CustomerProduct customerProduct  = new CustomerProduct(product, customer);
        customerProduct.setVisible(true);
        screen.dispose();
    }
    
    private int index = 0;
    
    public void moveProduct(String action) {
        DefaultListModel listModel = ProductServices.getDatabase();
        if (action.equals("next")) {
            index++;
            if (index > listModel.size()-1) index = 0;
        } else if (action.equals("previous")) {
            index--;
            if (index < 0) index = listModel.size() - 1;
        }
        Product product = (Product)listModel.getElementAt(index);
        nameField.setText(product.getName().toUpperCase());
        idField.setText(product.getId());
        descriptionField.setText(product.getDescription());
        priceField.setText("R$ "+product.getPrice());
        imageField.setIcon(new ImageIcon(product.getImage()));
        quantityField.setText("Selecionar");
    }
    
    public static Product getProduct(String productId) {
        try {
            return ProductDAO.get(productId);
        } catch (SQLException | IOException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static void updateProducts(Product product) {
        try {
            ProductDAO.update(product);
        } catch (SQLException | IOException ex) {
            Warning warning = new Warning("Erro ao atualizar.");
            warning.setVisible(true);
        }
    }
    
    public static void deleteProduct(Product product){
        try {
            ProductDAO.delete(product);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao excluir.");
            warning.setVisible(true);
        }
    }
}