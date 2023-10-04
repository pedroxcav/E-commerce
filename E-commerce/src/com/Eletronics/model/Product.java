package com.Eletronics.model;

import com.Eletronics.repository.ProductDAO;
import com.Eletronics.services.ProductServices;
import com.Eletronics.services.tools.Warning;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;

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
    
    public void registerProduct(Product product){
        try {
            if (!(ProductServices.verifyProduct(product.getId())))
                ProductDAO.register(product);
        } catch (SQLException | IOException e) {
            Warning warning = new Warning("Erro ao cadastrar.");
            warning.setVisible(true);
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
