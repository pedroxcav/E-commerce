/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.model;

import com.Eletronics.repository.ConexaoBD;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author pedro
 */
public class Product {
    String id;
    String name;
    String description;
    double price;
    InputStream image;

    public Product(String id, String name, String description, double price, InputStream image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }
    
    public void registerProduct(Product product){
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "insert into products (id,nome,descricao,valor,imagem) values (?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getPrice());
            ps.setBlob(5, product.getImage());
            ps.execute();
            System.out.println("Registrou!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean verifyProduct(String id){
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select id from products where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == false)
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public InputStream getImage() {
        return image;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setImage(InputStream image) {
        this.image = image;
    }
}
