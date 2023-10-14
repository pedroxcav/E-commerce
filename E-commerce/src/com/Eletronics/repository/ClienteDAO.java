package com.Eletronics.repository;

import com.Eletronics.model.Cliente;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import com.Eletronics.model.Usuario;
import java.sql.PreparedStatement;
import javax.swing.DefaultListModel;

public class ClienteDAO {
    
    public static boolean verificarID (Usuario cliente) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from cliente where id_Cliente = '"+cliente.getID()+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static boolean verificarCPF (Usuario cliente) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from cliente where CPF = '"+cliente.getCPF()+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static void regitsrar (Usuario cliente) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "insert into cliente (id_Cliente, nome, CPF, senha) values (?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cliente.getID());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getCPF());
            ps.setString(4, cliente.getSenha());
            ps.execute();
        }
    }
    
    public static boolean entrar (String ID_Cliente, String senha) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from cliente where id_Cliente = '"+ID_Cliente+"' and senha = '"+senha+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static DefaultListModel trazerClientes(String text) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from cliente where id_Cliente like '"+text+"%'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            DefaultListModel modelo = new DefaultListModel();
            while (rs.next()) {
                String ID_Cliente = rs.getString("id_Cliente");
                modelo.addElement(trazerCliente(ID_Cliente));
            }
            return modelo;
        }
    }
    
    public static Cliente trazerCliente(String ID_Cliente) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from cliente where id_Cliente = '"+ID_Cliente+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String nome = rs.getString("nome");
                String CPF = rs.getString("CPF");
                String senha = rs.getString("senha");
                return new Cliente(ID_Cliente, nome, CPF, senha);
            } else 
                return null;
        }
    }
    
    public static void excluir(Cliente cliente) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c =  cbd.obtemConexao()) {
            String sql = "delete from cliente where id_Cliente = '"+cliente.getID()+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
        }
    }
    
    public static void atualizar(Cliente cliente) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c =  cbd.obtemConexao()) {
            String sql = "update cliente set id_Cliente = ?, nome = ?, senha = ? where CPF = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cliente.getID());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getSenha());
            ps.setString(4, cliente.getCPF());
            ps.execute();
        }
    }
    
    public static boolean verificarAtualizacao(Cliente cliente) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from cliente where id_Cliente = ? and CPF != ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cliente.getID());
            ps.setString(2, cliente.getCPF());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
}
