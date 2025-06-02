package com.delicious.model;

public class Cheese extends Topping { // it inherits all fields and method from topping and it can override or add new behavior
    private boolean extra;
    private String flavor;


    // Constructor
    public Cheese(String flavor, double price, boolean extra) {
        super(flavor, price); // flavor is used as the name
        this.flavor = flavor;
        this.extra = extra;
    }

    @Override   // tells Java that a method in child class is replacing a method from its parent class
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