package com.delicious.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Sandwich {
    protected String size;
    protected String bread;
    protected boolean toasted;
    protected List<Topping> toppings = new ArrayList<>();

    public Sandwich(String size, String bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public String getBread() {
        return bread;
    }

    public String getSize() {
        return size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public abstract double calculatePrice();

    public String getDescription() {
        return size + " " + bread + (toasted ? " (toasted)" : "") + " with " + toppings.size() + " toppings";
    }
}
