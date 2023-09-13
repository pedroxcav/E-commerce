/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.services;

import com.Eletronics.model.Product;
import com.Eletronics.repository.ConexaoBD;
import com.Eletronics.view.Warning;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author pedro
 */
public class ProductServices {
    private final JLabel idField;
    private final JLabel nameField;
    private final JEditorPane descriptionField;
    private final JLabel priceField;
    private final JLabel imageField;
    private final JScrollPane scrollPane;
    private final JTextField searchField;
    private final JList list;
    
    private final ArrayList<Product> products = this.getProductDatabase();
    private int index = 0;

    public ProductServices(JLabel idField, JLabel nameField, JEditorPane descriptionField, JLabel priceField, JLabel imageField, JScrollPane scrollPane, JTextField searchField, JList list) {
        this.idField = idField;
        this.nameField = nameField;
        this.descriptionField = descriptionField;
        this.priceField = priceField;
        this.imageField = imageField;
        this.scrollPane =  scrollPane;
        this.searchField  = searchField;
        this.list = list;
    }
    
    private ArrayList<Product> getProductDatabase(){
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from products";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Product> model = new ArrayList<>();
            if (rs.next()==false)
                throw new Exception_NoProduct();
            else {
                do {
                    String ID = rs.getString("id");
                    String name = rs.getString("nome");
                    String description = rs.getString("descricao");
                    double price = rs.getDouble("valor");
                    Blob blob = rs.getBlob("imagem");
                    byte[] img = blob.getBytes(1, (int) blob.length());
                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(img));
                    model.add(new Product(ID, name, description, price, image));
                } while(rs.next());
                return model;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean setProduct(){
        if (products != null) {
            Product product = products.get(index);
            idField.setText(product.getId().toUpperCase());
            nameField.setText(product.getName().toUpperCase());
            descriptionField.setText(product.getDescription());
            priceField.setText("R$ "+product.getPrice());
            ImageIcon icon = new ImageIcon(product.getImage());
            imageField.setIcon(icon);
            return true;
        } else
            return false;
    }
    
    public void moveProduct(String action) {
        try {
            if (action.equals("next")) {
                index++;
                if (index > products.size()-1) index = 0;
            } else if (action.equals("previous")) {
                index--;
                if (index < 0) index = products.size() - 1;
            }
            if (!this.setProduct())
                throw new Exception_NoProduct();
        } catch (NullPointerException | Exception_NoProduct e) {
            Warning warning = new Warning("Não há produtos disponíveis!");
            warning.setVisible(true);
        }
    }
    
    public void searchProducts(){
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            DefaultListModel<String> model = new DefaultListModel<>();
            list.setModel(model);
            String sql = "select nome from products where nome like '"+searchField.getText()+"%'"+"order by nome";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == false || searchField.getText().isEmpty())
                scrollPane.setVisible(false);
            else {
                do
                    model.addElement(rs.getString("nome"));
                while (rs.next());
                scrollPane.setSize(294, 100);
                scrollPane.setVisible(true);
            }
        } catch (SQLException e){
            Warning warning = new Warning("Banco de dados [ERRO]");
            warning.setVisible(true);
        }
    }
    
    public void selectProduct() {
        String sql = "select * from products where nome like '"+searchField.getText()+"%' " + "order by nome limit "+index+", 1";
        ConexaoBD cbd = new ConexaoBD(); 
        try (Connection c = cbd.obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (!(rs.next() == false)) {
                do {
                    idField.setText(rs.getString("id"));
                    nameField.setText(rs.getString("nome").toUpperCase());
                    descriptionField.setText(rs.getString("descricao"));
                    priceField.setText("R$ "+String.valueOf(rs.getDouble("valor")));
                    Blob blob = rs.getBlob("imagem");
                    byte[] img = blob.getBytes(1, (int) blob.length());
                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(img));
                    ImageIcon icon = new ImageIcon(image);
                    imageField.setIcon(icon);
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
}