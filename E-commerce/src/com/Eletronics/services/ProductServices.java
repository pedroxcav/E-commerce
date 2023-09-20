/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.services;

import com.Eletronics.model.Customer;
import com.Eletronics.model.Product;
import com.Eletronics.repository.ConexaoBD;
import com.Eletronics.view.CustomerProduct;
import com.Eletronics.view.Warning;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author pedro
 */
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
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select id from products where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) throw new Exception_Data();
            else return false;
        } catch (Exception e) {
            return true;
        }
    }
    
    public static DefaultListModel searchProductDatabase(String text) {
        DefaultListModel listModel = new DefaultListModel();
        listModel.clear();
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from products where nome like '"+text+"%'";
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
            }
        } catch (Exception e) {
            Warning warning = new Warning("[ERRO]");
            warning.setVisible(true);
        }
        return listModel;
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
        DefaultListModel listModel = ProductServices.searchProductDatabase("");
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
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from products where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("nome");
                String description = rs.getString("descricao");
                double price = rs.getDouble("valor");
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(rs.getBytes("imagem")));
                return new Product(id,name,description,price,image);
            }
        } catch (Exception e) {
            Warning warning = new Warning("Produto indisponível!");
            warning.setVisible(true);
        }
        return null;
    }
    
    public static void updateProducts(Product product) {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "update products set nome = ?, descricao = ?, valor = ?, imagem = ? where id = '"+product.getId()+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(product.getImage(), "png", baos);
            Blob blob = new javax.sql.rowset.serial.SerialBlob(baos.toByteArray());
            ps.setBlob(4, blob);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteProduct(Product product){
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "delete from cart where produtoId = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.execute();
            sql = "delete from products where id = ?";
            ps = c.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}