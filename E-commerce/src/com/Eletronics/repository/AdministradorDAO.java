package com.Eletronics.repository;

import com.Eletronics.model.Administrador;
import com.Eletronics.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

public class AdministradorDAO {
    
    public static boolean verificarID (Usuario administrador) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from administrador where id_Administrador = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, administrador.getID());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static boolean verificarCPF (Usuario administrador) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from administrador where CPF = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, administrador.getCPF());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static void regitsrar (Usuario administrador) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "insert into administrador (nome, id_Administrador, CPF, senha) values (?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, administrador.getNome());
            ps.setString(2, administrador.getID());
            ps.setString(3, administrador.getCPF());
            ps.setString(4, administrador.getSenha());
            ps.execute();
        }
    }
    
    public static boolean entrar (String ID_Administrador, String senha) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from administrador where id_Administrador = '"+ID_Administrador+"' and senha = '"+senha+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static DefaultListModel trazerAdministradores(String text) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from administrador where id_Administrador like '"+text+"%'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            DefaultListModel modelo = new DefaultListModel();
            while (rs.next()) {
                String ID_Administrador = rs.getString("id_Administrador");
                modelo.addElement(trazerAdministrador(ID_Administrador));
            }
            return modelo;
        }
    }
    
    public static Administrador trazerAdministrador(String ID_Administrador) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from administrador where id_Administrador = '"+ID_Administrador+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String nome = rs.getString("nome");
                String CPF = rs.getString("CPF");
                String senha = rs.getString("senha");
                return new Administrador(ID_Administrador, nome, CPF, senha);
            } else 
                return null;
        }
    }
    
    public static void excluir(Administrador administrador) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c =  cbd.obtemConexao()) {
            String sql = "delete from administrador where id_Administrador = '"+administrador.getID()+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
        }
    }
    
    public static void atualizar(Administrador administrador) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c =  cbd.obtemConexao()) {
            String sql = "update administrador set id_Administrador = ?, nome = ?, senha = ? where CPF = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, administrador.getID());
            ps.setString(2, administrador.getNome());
            ps.setString(3, administrador.getSenha());
            ps.setString(4, administrador.getCPF());
            ps.execute();
        }
    }
    
    public static boolean verificarAtualizacao(Administrador administrador) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from administrador where id_Administrador = ? and CPF != ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, administrador.getID());
            ps.setString(2, administrador.getCPF());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
}
