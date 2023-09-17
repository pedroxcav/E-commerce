/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.services;

import com.Eletronics.model.Product;
import com.Eletronics.repository.ConexaoBD;
import com.Eletronics.view.CustomerProduct;
import com.Eletronics.view.Warning;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author pedro
 */
public class ProductServices {
    private JLabel nameField;
    private JLabel idField;
    private JLabel descriptionField;
    private JLabel priceField;
    private JLabel imageField;

    public ProductServices(JLabel nameField, JLabel idField, JLabel descriptionField, JLabel priceField, JLabel imageField) {
        this.nameField = nameField;
        this.idField = idField;
        this.descriptionField = descriptionField;
        this.priceField = priceField;
        this.imageField = imageField;
    }
    
    public static DefaultListModel getProductDatabase(){
        DefaultListModel listModel = new DefaultListModel();
        listModel.clear();
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from products";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do {
                    String id = rs.getString("id");
                    String name = rs.getString("nome");
                    String description = rs.getString("descricao");
                    double price = rs.getDouble("valor");
                    byte[] imageBytes = rs.getBytes("imagem");
                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
                    listModel.addElement(new Product(id, name, description, price, image));
                } while (rs.next());
            }
        } catch (Exception e) {
            Warning warning = new Warning("[ERRO]");
            warning.setVisible(true);
        }
        return listModel;
    }
    
    public static DefaultListModel searchProductDatabase(JTextField searchField, JScrollPane scrollPane) {
        DefaultListModel listModel = new DefaultListModel();
        listModel.clear();
        if (!searchField.getText().isEmpty()) {
            ConexaoBD cbd = new ConexaoBD();
            try (Connection c = cbd.obtemConexao()){
                String sql = "select * from products where nome like '"+searchField.getText()+"%'"+"order by nome";
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    do {
                        String id = rs.getString("id");
                        String name = rs.getString("nome");
                        String description = rs.getString("descricao");
                        double price = rs.getDouble("valor");
                        BufferedImage image = ImageIO.read(new ByteArrayInputStream(rs.getBytes("imagem")));
                        listModel.addElement(new Product(id, name, description, price, image));
                    } while (rs.next());
                    scrollPane.setSize(294, 292);
                    scrollPane.setVisible(true);
                }
            } catch (Exception e) {
                Warning warning = new Warning("[ERRO]");
                warning.setVisible(true);
            }
        } else
            scrollPane.setVisible(false);
        return listModel;
    }
    
    public static void showProduct(JFrame screen, JList list){
        DefaultListModel listModel = (DefaultListModel) list.getModel();
        Product product = (Product) listModel.getElementAt(list.getSelectedIndex());
        CustomerProduct customerProduct  = new CustomerProduct(product);
        customerProduct.setVisible(true);
        screen.dispose();
    }
    
    private int index = 0;
    
    public void moveProduct(String action) {
        DefaultListModel listModel = ProductServices.getProductDatabase();
        if (action.equals("next")) {
            index++;
            if (index > listModel.size()-1) index = 0;
        } else if (action.equals("previous")) {
            index--;
            if (index < 0) index = listModel.size() - 1;
        }
        this.setProduct((Product)listModel.getElementAt(index));
    }
    
    private void setProduct(Product product){
        nameField.setText(product.getName().toUpperCase());
        idField.setText(product.getId());
        descriptionField.setText(product.getDescription());
        priceField.setText("R$ "+product.getPrice());
        imageField.setIcon(new ImageIcon(product.getImage()));
    }
    
    public void addProduct(){
        Product product = this.getProduct(idField.getText());
        System.out.println("Nome: "+product.getName()+"\nID: "+product.getId());
    }
    
    private Product getProduct(String productId) {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from products where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String name = rs.getString("nome");
                String id = rs.getString("id");
                String description = rs.getString("descricao");
                double price = rs.getDouble("valor");
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(rs.getBytes("imagem")));
                return new Product(name,id,description,price,image);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Warning warning = new Warning("Produto indisponível!");
            warning.setVisible(true);
        }
        return null;
    }
    
    /*
    if (action.equals("next")) {
        index++;
        if (index > products.size()-1) index = 0;
    } else if (action.equals("previous")) {
        index--;
        if (index < 0) index = products.size() - 1;
    }
    
    public void getSearchedProduct() {
        index = list.getSelectedIndex();
        String sql = "select * from products where nome like '"+searchField.getText()+"%' " + "order by nome limit "+index+", 1";
        ConexaoBD cbd = new ConexaoBD(); 
        try (Connection c = cbd.obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql); 
            ResultSet rs = ps.executeQuery();
            if (!(rs.next() == false)) {
                do {
                    String id = rs.getString("id");
                    String name = rs.getString("nome").toUpperCase();
                    String description = rs.getString("descricao");
                    double price = rs.getDouble("valor");
                    byte[] imageBytes = rs.getBytes("imagem");
                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
                    Product product = new Product(id,name,description,price,image);
                } while (rs.next());
            }
        } catch (IOException ex) {
            Warning warning = new Warning("Imagem [ERRO]");
            warning.setVisible(true);
        } catch (SQLException e) {
            Warning warning = new Warning("Banco de dados [ERRO]");
            warning.setVisible(true);
        } finally {
            scrollPane.setVisible(false);
        } 
    };
    */
}