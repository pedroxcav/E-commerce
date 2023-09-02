/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license   
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.model;

import com.Eletronics.repository.ConexaoBD;
import com.Eletronics.services.CPF_Exception;
import com.Eletronics.services.UserCPF_Exception;
import com.Eletronics.services.User_Exception;
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
    public Customer(){}
    
    @Override
    public void registerUser(User customer) {
        try {
            if (!(this.verifyUser(customer))){
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
        } catch (User_Exception | CPF_Exception | UserCPF_Exception e) {
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
            e.printStackTrace();
        }
        Warning warning = new Warning("Acesso incorreto!");
        warning.setVisible(true);
        return false;
    }
    @Override
    protected boolean verifyUser(User customer) throws SQLException, User_Exception, CPF_Exception, UserCPF_Exception{
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
                if (errorType == 1)
                    throw new User_Exception("Usuário já utilizado!");
                else if (errorType == 2)
                    throw new CPF_Exception("Este CPF já foi utilizado!");
                else
                    throw new UserCPF_Exception("Usuário e CPF já utilizados!");
            }
        }
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
