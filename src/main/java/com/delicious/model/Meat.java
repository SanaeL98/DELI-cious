package com.delicious.model;

public class Meat extends Topping {   //inherits flavor and price
    private boolean extra;
    private String flavor;

    public Meat(String flavor, double price, boolean extra) {
        super(flavor, price); // flavor is used as the name
        this.flavor = flavor;
        this.extra = extra;
    }

    @Override
    public double getPrice() {
        return extra ? super.getPrice() + 1.50 : super.getPrice();
    }

    public String getFlavor() {  // returns what kind of meat it is
        return flavor;
    }

    public boolean hasExtra() {
        return extra;
    }
}
