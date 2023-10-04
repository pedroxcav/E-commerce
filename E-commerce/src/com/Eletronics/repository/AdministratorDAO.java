package com.Eletronics.repository;

import com.Eletronics.model.Administrator;
import com.Eletronics.model.User;
import com.Eletronics.services.exceptions.Exception_Data;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

public class AdministratorDAO {
    
    public static void register(User administrator) throws SQLException{
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
                String sql = "insert into administrators (nome,usuario,CPF,senha) values (?,?,?,?)";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, administrator.getName());
                ps.setString(2, administrator.getUserId());
                ps.setString(3, administrator.getCPF());
                ps.setString(4, administrator.getPassword());
                ps.execute();
        }
    }
    
    public static boolean LogInto(String userId, String password) throws SQLException{
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select usuario,senha from administrators where usuario = ? and senha = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static boolean verifyId(User administrator) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from administrators where usuario = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, administrator.getUserId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return true;
        }
        return false;
    }
    
    public static boolean verifyCPF(User administrator) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from administrators where CPF = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, administrator.getCPF());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return true;
        }
        return false;
    }
    
    public static Administrator getUser(String userId) throws SQLException{
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from administrators where usuario = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String name = rs.getString("nome");
                String id = rs.getString("usuario");
                String CPF = rs.getString("CPF");
                int password = rs.getInt("senha");
                return new Administrator(name,id,CPF,String.valueOf(password));
            } else
                return null;
        }
    }
    
    public static DefaultListModel getDatabase() throws SQLException{
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from administrators";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            DefaultListModel listModel = new DefaultListModel();
            while (rs.next()) {
                String name = rs.getString("nome");
                String id = rs.getString("usuario");
                String CPF = rs.getString("CPF");
                String password = rs.getString("senha");
                listModel.addElement(new Administrator(name, id, CPF, password));
            }
            return listModel;
        }
    }
    
    public static void delete(Administrator administrator) throws SQLException{
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "delete from administrators where usuario  = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, administrator.getUserId());
            ps.execute();
        }
    }
    
    public static void update(Administrator administrator) throws SQLException, Exception_Data{
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from administrators where usuario = ? and CPF != ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, administrator.getUserId());
            ps.setString(2, administrator.getCPF());
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                throw new Exception_Data("Usuário já utilizado!");
            else {
                sql = "update administrators set nome = ?, usuario = ?, senha = ? where CPF = '"+administrator.getCPF()+"'";
                ps = c.prepareStatement(sql);
                ps.setString(1, administrator.getName());
                ps.setString(2, administrator.getUserId());
                ps.setString(3, administrator.getPassword());
                ps.execute();
            }
        }
    }
}
