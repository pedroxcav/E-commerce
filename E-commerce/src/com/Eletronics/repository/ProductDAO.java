package com.Eletronics.repository;

import com.Eletronics.model.Product;
import com.Eletronics.services.exceptions.Exception_Data;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;

public class ProductDAO {
    
    public static void register (Product product) throws SQLException, IOException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "insert into products (id,nome,descricao,valor,imagem) values (?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getPrice());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(product.getImage(), "png", baos);
            Blob blob = new javax.sql.rowset.serial.SerialBlob(baos.toByteArray());
            ps.setBlob(5, blob);
            ps.execute();
        }
    }
    public static boolean verify(String id) throws SQLException, Exception_Data{
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select id from products where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) throw new Exception_Data();
            else return false;
        }
    }
    
    public static DefaultListModel getDatabase(String text) throws SQLException, IOException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from products where nome like '"+text+"%'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            DefaultListModel listModel = new DefaultListModel();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("nome");
                String description = rs.getString("descricao");
                double price = rs.getDouble("valor");
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(rs.getBytes("imagem")));
                listModel.addElement(new Product(id, name, description, price, image));
            }
            return listModel;
        }
    }
    
    public static Product get(String productId) throws SQLException, IOException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from products where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("nome");
                String description = rs.getString("descricao");
                double price = rs.getDouble("valor");
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(rs.getBytes("imagem")));
                return new Product(id,name,description,price,image);
            } else
                return null;
        }
    }
    
    public static void update (Product product) throws SQLException, IOException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "update products set nome = ?, descricao = ?, valor = ?, imagem = ? where id = '"+product.getId()+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(product.getImage(), "png", baos);
            Blob blob = new javax.sql.rowset.serial.SerialBlob(baos.toByteArray());
            ps.setBlob(4, blob);
            ps.execute();
        }
    }
    
    public static void delete (Product product) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "delete from products where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps = c.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.execute();
        }
    }
}
