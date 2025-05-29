package com.delicious.model;

public class Cheese extends Topping {
    private boolean extra;
    private String flavor;

    public Cheese(String flavor, double price, boolean extra) {
        super(flavor, price); // flavor is used as the name
        this.flavor = flavor;
        this.extra = extra;
    }

    @Override
    public double getPrice() {
        return extra ? super.getPrice() + 1.00 : super.getPrice();
    }

    public String getFlavor() {
        return flavor;
    }

    public boolean hasExtra() {
        return extra;
    }
}