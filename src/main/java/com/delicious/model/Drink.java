package com.delicious.model;

public class Drink {
    private String flavor;
    private String size;
    private boolean extra;

    public Drink(String flavor, String size, boolean extra) {
        this.flavor = flavor;
        this.size = size;
        this.extra = extra;
    }

    public double getPrice() {
        double base = switch (size.toLowerCase()) {
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 2.00; // default small
        };
        return extra ? base + 1.00 : base;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    public boolean hasExtra() {
        return extra;
    }
}
