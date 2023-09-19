/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.model;

import com.Eletronics.repository.ConexaoBD;
import com.Eletronics.services.Exception_Data;
import com.Eletronics.view.Warning;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;

/**
 *
 * @author pedro
 */
public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private BufferedImage image;
    
    public Product(String id, String name, String description, double price, BufferedImage image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }
    public Product() {}
    
    public void registerProduct(Product product){
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            if (verifyProduct(id)) throw new Exception_Data("ID já utilizado!");
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
        } catch (Exception_Data e) {
            Warning warning = new  Warning(e.getMessage());
            warning.setVisible(true);
        } catch (Exception e) {
            Warning warning = new Warning("Produto não cadastrado!");
            warning.setVisible(true);
        }
    }
    
    public static boolean verifyProduct(String id) {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select id from products where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) throw new Exception_Data();
            else return false;
        } catch (Exception e) {
            return true;
        }
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public BufferedImage getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
