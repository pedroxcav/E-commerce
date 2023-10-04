package com.Eletronics.repository;

import com.Eletronics.model.Customer;
import com.Eletronics.model.User;
import com.Eletronics.services.exceptions.Exception_Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

public class CustomerDAO {
    
    public static void register(User customer) throws SQLException {
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
    
    public static boolean logInto(String userId, String password) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select usuario,senha from customers where usuario = ? and senha = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static boolean verifyId(User customer) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from customers where usuario = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, customer.getUserId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return true;
        }
        return false;
    }
    
    public static boolean verifyCPF(User customer) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from customers where CPF = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, customer.getCPF());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return true;
        }
        return false;
    }
    
    public static Customer getUser(String customerId) throws SQLException{
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
                String telephone = rs.getString("celular");
                String address = rs.getString("endereco");
                return new Customer(name,id,CPF,String.valueOf(password),telephone,address);
            } else
                return null;
        }
    }
    
    public static DefaultListModel getDatabase(String text) throws SQLException{
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from customers where usuario like '"+text+"%'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            DefaultListModel listModel = new DefaultListModel();
            while (rs.next()) {
                String name = rs.getString("nome");
                String id = rs.getString("usuario");
                String CPF = rs.getString("CPF");
                String password = rs.getString("senha");
                String telephone = rs.getString("celular");
                String address = rs.getString("endereco");
                listModel.addElement(new Customer(name,id,CPF,password,telephone,address));
            }
            return listModel;
        }
    }
    
    public static void delete (Customer customer) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "delete from customers where usuario = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps = c.prepareStatement(sql);
            ps.setString(1, customer.getUserId());
            ps.execute();
        }
    }
    
    public static void update (Customer customer) throws SQLException, Exception_Data {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from customers where usuario = ? and CPF != ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, customer.getUserId());
            ps.setString(2, customer.getCPF());
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                throw new Exception_Data("Usuário já utilizado!");
            else {
                sql = "select * from customers where celular = ? and CPF != ?";
                ps = c.prepareStatement(sql);
                ps.setString(1, customer.getTelephone());
                ps.setString(2, customer.getCPF());
                rs = ps.executeQuery();
                if (rs.next())
                    throw new Exception_Data("Celular já cadastrado!");
                else {
                    sql = "update customers set nome = ?, usuario = ?, senha = ?, celular = ?, endereco = ? where CPF = '"+customer.getCPF()+"'";
                    ps = c.prepareStatement(sql);
                    ps.setString(1, customer.getName());
                    ps.setString(2, customer.getUserId());
                    ps.setString(3, customer.getPassword());
                    ps.setString(4, customer.getTelephone().isEmpty() ? null : customer.getTelephone());
                    ps.setString(5, customer.getAddress().isEmpty() ? null : customer.getAddress());
                    ps.execute();
                }
            }
        }
    }
}
