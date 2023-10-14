package com.Eletronics.repository;

import com.Eletronics.model.Carrinho;
import com.Eletronics.model.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarrinhoDAO {
    
    public static boolean verificar(String ID_Carrinho) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from carrinho where id_Carrinho = '"+ID_Carrinho+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static void registar (Carrinho carrinho) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "insert into carrinho (id_Carrinho, id_Cliente) values (?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, carrinho.getID_Carrinho());
            ps.setString(2, carrinho.getID_Cliente());
            ps.execute();
        }
    }
    
    public static Carrinho trazerCarrinho(Cliente cliente) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            Carrinho carrinho = null;
            String sql = "select * from carrinho where id_Cliente = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cliente.getID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String ID_Carrinho = rs.getString("id_Carrinho");
                String ID_Cliente = rs.getString("id_Cliente");
                carrinho = new Carrinho(ID_Carrinho, ID_Cliente);
            }
            return carrinho;
        }
    }
}
