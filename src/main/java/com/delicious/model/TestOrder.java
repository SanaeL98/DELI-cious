package com.delicious.model;

import com.delicious.model.Order;
import com.delicious.data.Receipt;
import com.delicious.model.CustomSandwich;
import com.delicious.model.Cheese;
import com.delicious.model.Meat;
import com.delicious.model.RegularTopping;
import com.delicious.model.Drink;
import com.delicious.model.Chips;

public class TestOrder {
    public static void main(String[] args) {
        // Create an Order object
        Order order = new Order();

        // Create a custom sandwich
        CustomSandwich sandwich = new CustomSandwich("medium", "wheat", true);
        sandwich.addTopping(new Cheese("Cheddar", 0.75, true));
        sandwich.addTopping(new Meat("Turkey", 2.00, false));
        sandwich.addTopping(new RegularTopping("Lettuce", 0.00));
        order.addSandwich(sandwich);

        // Add a drink
        Drink drink = new Drink("Lemonade", "medium", false);
        order.addDrink(drink);

        // Add chips
        Chips chips = new Chips("BBQ", 1.50);
        order.addChips(chips);

        // Print the receipt
        Receipt receipt = new Receipt(order);
        receipt.printReceipt();
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 4510970 (DELI-cious)
