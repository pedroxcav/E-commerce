package com.Eletronics.repository;

import com.Eletronics.model.Carrinho;
import com.Eletronics.model.Pedido;
import com.Eletronics.model.Produto;
import com.Eletronics.services.ProdutoServices;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

public class PedidoDAO {
    
    public static boolean verificar(String ID_Pedido) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from pedido where id_Pedido = '"+ID_Pedido+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static void salvar(Pedido pedido) throws SQLException, IOException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "insert into pedido values (?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, pedido.getID_Pedido());
            ps.setString(2, pedido.getID_carrinho());
            ps.setString(3, pedido.getProduto().getID_Produto());
            ps.setInt(4, pedido.getQuantidade());
            ps.setDouble(5, pedido.getValor());
            ps.execute();
        }
    }
    
    public static DefaultListModel trazerPedidos(Carrinho carrinho) throws SQLException, IOException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from pedido where id_Carrinho = '"+carrinho.getID_Carrinho()+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            DefaultListModel modelo = new DefaultListModel();
            while(rs.next()) {
                String ID_Pedido = rs.getString("id_Pedido");
                modelo.addElement(PedidoDAO.trazerPedido(ID_Pedido));
            }
            return modelo;
        }
    }
    
    private static Pedido trazerPedido(String ID_Pedido) throws SQLException, IOException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from pedido where id_Pedido = '"+ID_Pedido+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String ID_Carrinho = rs.getString("ID_Carrinho");
                Produto produto = ProdutoServices.trazerProduto(rs.getString("id_Produto"));
                int quantidade = rs.getInt("quantidade");
                return new Pedido(ID_Pedido, ID_Carrinho, produto, quantidade);
            } else
                return null;
        }
    }
    
    public static void excluir(Pedido pedido) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "delete from pedido where id_Pedido = '"+pedido.getID_Pedido()+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
        }
    }
    
    public static void atualizar(Pedido pedido) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "update pedido set quantidade = ?, valor = ? where id_Pedido = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, pedido.getQuantidade());
            ps.setDouble(2, pedido.getValor());
            ps.setString(3, pedido.getID_Pedido());
            ps.execute();
        }
    }
}
