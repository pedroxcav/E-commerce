package com.Eletronics.repository;

import com.Eletronics.model.Item;
import com.Eletronics.services.exceptions.Exception_Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAO {
    
    public static void update(Item item) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "update cart set quantidade = ?, valor = ? where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, item.getQuantity());
            ps.setDouble(2, item.getProduct().getPrice()*item.getQuantity());
            ps.setString(3, item.getItemId());
            ps.execute();
        }
    }
    
    public static void delete(Item item) throws SQLException{
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "delete from cart where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, item.getItemId());
            ps.execute();
        }
    }
    
    public static void verify(String id) throws SQLException, Exception_Data{
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select id from cart where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) throw new Exception_Data();
        }
    }
}
