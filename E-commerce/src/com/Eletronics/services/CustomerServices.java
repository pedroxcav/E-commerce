/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.services;

import com.Eletronics.model.Customer;
import com.Eletronics.model.User;
import com.Eletronics.repository.ConexaoBD;
import com.Eletronics.view.Warning;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

/**
 *
 * @author pedro
 */
public class CustomerServices {
    
    public static boolean verifyCustomer(User customer) throws SQLException, Exception_Data {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select usuario,CPF from customers where usuario = ? or CPF = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, customer.getUserId());
            ps.setString(2, customer.getCPF());
            ResultSet rs = ps.executeQuery();
            if (rs.next() == false)
                return false;
            else {
                int errorType = 0;
                do {
                    String usuario = rs.getString("usuario");
                    String CPF = rs.getString("CPF");
                    if (usuario.equals(customer.getUserId()))
                        errorType++;
                    if (CPF.equals(customer.getCPF()))
                        errorType+=2;
                } while (rs.next());
                switch (errorType) {
                    case 1:
                        throw new Exception_Data("Usuário já utilizado!");
                    case 2:
                        throw new Exception_Data("Este CPF já foi utilizado!");
                    default:
                        throw new Exception_Data("Usuário e CPF já utilizados!");
                }
            }
        }
    }
    
    public static Customer getCustomer(String customerId) {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from customers where usuario = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String name = rs.getString("nome");
                String id = rs.getString("usuario");
                String CPF = rs.getString("CPF");
                int password = rs.getInt("senha");
                return new Customer(name,id,CPF,String.valueOf(password));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Warning warning = new Warning("Usuário indisponível!");
            warning.setVisible(true);
        }
        return null;
    }
    
    public static DefaultListModel searchCustomerDatabase(String text){
        DefaultListModel listModel = new DefaultListModel();
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from customers where usuario like '"+text+"%'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {
                    String name = rs.getString("nome");
                    String id = rs.getString("usuario");
                    String CPF = rs.getString("CPF");
                    String password = rs.getString("senha");
                    listModel.addElement(new Customer(name,id,CPF,password));
                } while (rs.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listModel;
    }
    
    public static void deleteCustomer(Customer customer){
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "delete from customers where usuario = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, customer.getUserId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void updateCustomers(Customer customer) {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "update customers set nome = ?, usuario = ?, senha = ? where CPF = '"+customer.getCPF()+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getUserId());
            ps.setString(3, customer.getPassword());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
