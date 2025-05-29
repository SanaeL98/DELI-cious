package com.delicious.model;

public class Chips {
    private String flavor;
    private double price;

    public Chips(String flavor, double price) {
        this.flavor = flavor;
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        return price;
    }
}
