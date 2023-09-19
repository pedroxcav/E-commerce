/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.model;

import com.Eletronics.repository.ConexaoBD;
import com.Eletronics.services.Exception_Data;
import com.Eletronics.services.RandomGenerator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author pedro
 */
public class Item {
    private String itemId;
    private String userId;
    private Product product;
    private int quantity;
    private double price;

    public Item(String userId, Product product, int quantity) {
        this.itemId = RandomGenerator.generateIdItem();
        this.userId = userId;
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice()*quantity;
    }

    public Item(String itemId, String userId, Product product, int quantity, double price) {
        this.itemId = itemId;
        this.userId = userId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
    
    public static boolean verifyItem(String id){
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select id from cart where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) throw new Exception_Data();
            else return false;
        } catch (Exception e) {
            return true;
        }
    }
    
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
