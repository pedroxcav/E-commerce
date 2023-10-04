package com.Eletronics.repository;

import com.Eletronics.model.Item;
import com.Eletronics.model.Product;
import com.Eletronics.services.ProductServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

public class CartDAO {
    
    public static void addToDatabase(Item item) throws SQLException{
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "insert into cart (id, usuario, produtoId, quantidade, valor) values (?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, item.getItemId());
            ps.setString(2, item.getUserId());
            ps.setString(3, item.getProduct().getId());
            ps.setInt(4, item.getQuantity());
            ps.setDouble(5, item.getPrice());
            ps.execute();
        }
    }
    
    public static DefaultListModel getDatabase(String userId) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        DefaultListModel listModel = new DefaultListModel();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from cart where usuario = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String itemId = rs.getString("id");
                Product product = ProductServices.getProduct(rs.getString("produtoId"));
                int quantity = rs.getInt("quantidade");
                double price = rs.getDouble("valor");
                listModel.addElement(new Item(itemId, userId, product, quantity, price));
            }
            return listModel;
        }
    }
}
