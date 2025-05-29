package com.delicious.order;

import com.delicious.model.*;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public double calculateTotal() {
        double total = 0;
        for (Sandwich s : sandwiches) {
            total += s.calculatePrice();
        }
        for (Drink d : drinks) {
            total += d.getPrice();
        }
        for (Chips c : chips) {
            total += c.getPrice();
        }
        return total;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }
}
