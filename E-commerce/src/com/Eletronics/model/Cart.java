/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.model;

import com.Eletronics.repository.ConexaoBD;
import com.Eletronics.services.Exception_Data;
import com.Eletronics.services.ProductServices;
import com.Eletronics.view.Warning;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author pedro
 */
public class Cart {
    public static void addProduct(Customer customer, String productId, int quantity){
        Product product = ProductServices.getProduct(productId);
        Item item = new Item(customer.getUserId(), product, quantity);
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            if (ProductServices.verifyProduct(item.getItemId())) throw new Exception_Data();
            String sql = "insert into cart (id, usuario, produtoId, quantidade, valor) values (?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, item.getItemId());
            ps.setString(2, item.getUserId());
            ps.setString(3, item.getProduct().getId());
            ps.setInt(4, item.getQuantity());
            ps.setDouble(5, item.getPrice());
            ps.execute();
        } catch (Exception_Data e) {
            Warning warning = new  Warning("[ERRO]");
            warning.setVisible(true);
        } catch (Exception e) {
            Warning warning = new Warning("Falha ao adicionar.");
            warning.setVisible(true);
        }
    }
    
    public static DefaultListModel getCart(String userId){
        ConexaoBD cbd = new ConexaoBD();
        DefaultListModel listModel = new DefaultListModel();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from cart where usuario = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {
                    String itemId = rs.getString("id");
                    Product product = ProductServices.getProduct(rs.getString("produtoId"));
                    int quantity = rs.getInt("quantidade");
                    double price = rs.getDouble("valor");
                    listModel.addElement(new Item(itemId, userId, product, quantity, price));
                } while (rs.next());
            }
        } catch (Exception e) {
            Warning warning = new  Warning("[ERRO]");
            warning.setVisible(true);
        }
        return listModel;
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
    
    public static double getTotalPrice(JList cartList){
        double totalPrice = 0;
        DefaultListModel listModel = (DefaultListModel) cartList.getModel();
        for (int i=0; i < listModel.getSize(); i++){
            Item item = (Item) listModel.getElementAt(i);
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    
    public static void updateItem(Item item){
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "update cart set quantidade = ?, valor = ? where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, item.getQuantity());
            ps.setDouble(2, item.getProduct().getPrice()*item.getQuantity());
            ps.setString(3, item.getItemId());
            ps.execute();
        } catch (Exception e) {
            Warning warning = new Warning("[ERRO]");
            warning.setVisible(true);
        }
    }
    
    public static void deleteItem(Item item){
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "delete from cart where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, item.getItemId());
            ps.execute();
        } catch (Exception e) {
            Warning warning = new Warning("[ERRO]");
            warning.setVisible(true);
        }
    }
}
