/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.services;

import com.Eletronics.model.Item;
import com.Eletronics.repository.ConexaoBD;
import com.Eletronics.view.Warning;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author pedro
 */
public class CartServices {
    
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
