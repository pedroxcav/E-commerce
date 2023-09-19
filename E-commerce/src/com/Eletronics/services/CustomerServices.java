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

/**
 *
 * @author pedro
 */
public class CustomerServices {
    
    public static boolean verifyUser(User customer) throws SQLException, Exception_Data {
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
}
