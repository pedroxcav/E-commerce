package com.Eletronics.model;

import com.Eletronics.services.tools.RandomGenerator;

public class Item {
    private String itemId;
    private String userId;
    private Product product;
    private int quantity;
    private double price;

    public Item(String userId, Product product, int quantity) {
        this.itemId = RandomGenerator.generateIdItem();
        this.userId = userId;
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice()*quantity;
    }

    public Item(String itemId, String userId, Product product, int quantity, double price) {
        this.itemId = itemId;
        this.userId = userId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
