package com.Eletronics.repository;

import com.Eletronics.model.Compra;
import com.Eletronics.model.Produto;
import com.Eletronics.model.Venda;
import com.Eletronics.services.ProdutoServices;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

public class VendaDAO {
    
    public static boolean verificar(String ID_Venda) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from venda where id_Venda = '"+ID_Venda+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static void salvar(Venda venda) throws SQLException, IOException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "insert into venda values (?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, venda.getID_Venda());
            ps.setString(2, venda.getID_Compra());
            ps.setString(3, venda.getProduto().getID_Produto());
            ps.setString(4, venda.getID_Endereco());
            ps.setInt(5, venda.getQuantidade());
            ps.setDouble(6, venda.getValor());
            ps.execute();
        }
    }
    
    public static DefaultListModel trazerVendas(Compra compra) throws SQLException, IOException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from venda where id_Compra = '"+compra.getID_Compra()+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            DefaultListModel modelo = new DefaultListModel();
            while(rs.next()) {
                String ID_Venda = rs.getString("id_Venda");
                modelo.addElement(VendaDAO.trazerVenda(ID_Venda));
            }
            return modelo;
        }
    }
    
    public static DefaultListModel trazerVendas() throws SQLException, IOException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from venda";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            DefaultListModel modelo = new DefaultListModel();
            while(rs.next()) {
                String ID_Venda = rs.getString("id_Venda");
                modelo.addElement(VendaDAO.trazerVenda(ID_Venda));
            }
            return modelo;
        }
    }
    
    private static Venda trazerVenda(String ID_Venda) throws SQLException, IOException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from venda where id_Venda = '"+ID_Venda+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String ID_Compra = rs.getString("id_Compra");
                String ID_Endereco = rs.getString("id_Endereco");
                Produto produto = ProdutoServices.trazerProduto(rs.getString("id_Produto"));
                int quantidade = rs.getInt("quantidade");
                double valor = rs.getDouble("valor");
                return new Venda(ID_Venda, ID_Compra, ID_Endereco, produto, quantidade, valor);
            } else
                return null;
        }
    }
}
