package com.delicious.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Sandwich {   // cannot be instantiated directly. It's meant to be extended by other classes that will implement the abstract methods
    protected String size;  // subclasses can access and use these fields directly without needing getters
    protected String bread;
    protected boolean toasted;
    protected List<Topping> toppings = new ArrayList<>();

    //Constructor

    public Sandwich(String size, String bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
    }  //  called when the subclass is created

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public String getBread() {
        return bread;
    }

    public String getSize() {    // These getter methods allow
        return size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public abstract double calculatePrice(); // it declares that all sandwiches must have a calculatePrice()

    public String getDescription() {
        return size + " " + bread + (toasted ? " (toasted)" : "") + " with " + toppings.size() + " toppings";
    }
}
