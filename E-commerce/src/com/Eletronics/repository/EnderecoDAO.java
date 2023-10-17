package com.Eletronics.repository;

import com.Eletronics.model.Cliente;
import com.Eletronics.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

public class EnderecoDAO {
    
    public static boolean verificar(String ID_Endereco) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from endereco where id_Endereco = '"+ID_Endereco+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static DefaultListModel trazerEnderecos(Cliente cliente) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from endereco where id_Cliente = '"+cliente.getID()+"' and ativo = true";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            DefaultListModel modelo = new DefaultListModel();
            while (rs.next()) {
                String ID_Endereco = rs.getString("id_Endereco");
                modelo.addElement(trazerEndereco(ID_Endereco));
            }
            return modelo;
        }
    }
    
    public static Endereco trazerEndereco(String ID_Endereco) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from endereco where id_Endereco = '"+ID_Endereco+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String ID_Cliente = rs.getString("id_Cliente");
                String CEP = rs.getString("CEP");
                String rua = rs.getString("rua");
                String numero = rs.getString("numero");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                return new Endereco(ID_Endereco, ID_Cliente, CEP, rua, numero, bairro, cidade);
            } else
                return null;
        }
    }
    
    public static void excluir(Endereco endereco) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c =  cbd.obtemConexao()) {
            String sql = "update endereco set ativo = false where id_Endereco = '"+endereco.getID_Endereco()+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
        }
    }
    
    public static void registrar(Endereco endereco) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "insert into endereco (id_Endereco, id_Cliente, CEP, rua, numero, bairro, cidade) values (?,?,?,?,?,?,?);";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, endereco.getID_Endereco());
            ps.setString(2, endereco.getID_Cliente());
            ps.setString(3, endereco.getCEP());
            ps.setString(4, endereco.getRua());
            ps.setString(5, endereco.getNumero());
            ps.setString(6, endereco.getBairro());
            ps.setString(7, endereco.getCidade());
            ps.execute();
        }
    }
}
