package com.delicious.model;

public class Chips {
    private String flavor;
    private double price;


    // Constructor
    public Chips(String flavor, double price) {
        this.flavor = flavor;
        this.price = price;
    }  // create a chips object with a specific flavor and price

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        return price;
    }  // they allow you to retrieve the values of the private variables
}
