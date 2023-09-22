/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license   
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.model;

import com.Eletronics.repository.ConexaoBD;
import com.Eletronics.services.CustomerServices;
import com.Eletronics.services.Exception_Data;
import com.Eletronics.view.Warning;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class Customer extends User {
    private String telephone;
    private String address;

    public Customer(String name, String userId, String CPF, String password) {
        super(name, userId, CPF, password);
    }
    public Customer(){
        super();
    }
    
    @Override
    public void registerUser(User customer) {
        try {
            if (!(CustomerServices.verifyCustomer(customer))){
                ConexaoBD cbd = new ConexaoBD();
                try (Connection c = cbd.obtemConexao()) {
                    String sql = "insert into customers (nome,usuario,CPF,senha) values (?,?,?,?)";
                    PreparedStatement ps = c.prepareStatement(sql);
                    ps.setString(1, customer.getName());
                    ps.setString(2, customer.getUserId());
                    ps.setString(3, customer.getCPF());
                    ps.setString(4, customer.getPassword());
                    ps.execute();
                }
            }
        } catch (SQLException e) {
            Warning warning = new Warning("Não foi possível cadastrar.");
            warning.setVisible(true);
        } catch (Exception_Data e) {
            Warning warning = new Warning(e.getMessage());
            warning.setVisible(true);
        }
    }
    @Override
    public boolean logInto(String userId, String password) {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select usuario,senha from customers where usuario = ? and senha = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return true;
        } catch (SQLException e) {
            Warning warning = new Warning("Não foi possível entrar.");
            warning.setVisible(true);
        }
        Warning warning = new Warning("Acesso incorreto!");
        warning.setVisible(true);
        return false;
    }

    public String getTelephone() {
        return telephone;
    }
    public String getAddress() {
        return address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
