package com.Billing.Bill.Generation.System.Modules;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long productId;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private double gst;

    @Column
    private int inventory;

    // Getter and setter for gst using getGst() and setGst()
    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    // Other getters and setters
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Product() {}

    public Product(long id, String name, double price, double gst, int inventory) {
        this.productId = id;
        this.name = name;
        this.price = price;
        this.gst = gst;
        this.inventory = inventory;
    }




}
