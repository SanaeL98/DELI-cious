package com.delicious.model;

public class CustomSandwich extends Sandwich {

    public CustomSandwich(String size, String bread, boolean toasted) {
        super(size, bread, toasted);
    }

    @Override
    public double calculatePrice() {
        double basePrice;

        switch (size.toLowerCase()) {
            case "small" -> basePrice = 5.00;
            case "medium" -> basePrice = 6.50;
            case "large" -> basePrice = 8.00;
            default -> basePrice = 6.00; // default fallback
        }

        for (Topping topping : toppings) {
            basePrice += topping.getPrice();
        }

        return basePrice;
    }
}
