package com.delicious.data;

import com.delicious.model.*;
import com.delicious.model.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private Order order;

    public Receipt(Order order) {
        this.order = order;
    }

    public void printReceipt() {
        System.out.println("\n====== DELI-cious Receipt ======");

        // Date/Time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' h:mm a");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Order Date/Time: " + dtf.format(now));
        System.out.println();

        // Sandwiches
        for (Sandwich sandwich : order.getSandwiches()) {
            System.out.print("Sandwich: ");
            System.out.printf("%s Bread", sandwich.getBread());

            for (Topping topping : sandwich.getToppings()) {
                if (topping instanceof Meat) {
                    System.out.print(" with " + topping.getName());
                    break;
                }
            }

            System.out.printf("  $%.2f\n", sandwich.calculatePrice());

            System.out.print("Toppings: ");
            boolean first = true;
            for (Topping topping : sandwich.getToppings()) {
                if (!(topping instanceof Meat || topping instanceof Cheese)) {
                    if (!first) System.out.print(", ");
                    System.out.print(topping.getName());
                    first = false;
                }
            }
            System.out.println();

            System.out.print("Cheese: ");
            for (Topping topping : sandwich.getToppings()) {
                if (topping instanceof Cheese) {
                    System.out.print(topping.getName());
                }
            }
            System.out.println();

            System.out.print("Sauce: ");
            boolean found = false;
            for (Topping topping : sandwich.getToppings()) {
                if (topping.getName().equalsIgnoreCase("Mayo") ||
                        topping.getName().equalsIgnoreCase("Mustard") ||
                        topping.getName().equalsIgnoreCase("Ranch") ||
                        topping.getName().equalsIgnoreCase("Vinaigrette") ||
                        topping.getName().equalsIgnoreCase("Ketchup") ||
                        topping.getName().equalsIgnoreCase("Thousand Islands")) {
                    System.out.print(topping.getName());
                    found = true;
                }
            }
            if (!found) System.out.print("None");
            System.out.println();
        }

        // Chips
        for (Chips chip : order.getChips()) {
            System.out.printf("Chips: %-10s $%.2f\n", chip.getFlavor(), chip.getPrice());
        }

        // Drinks
        for (Drink drink : order.getDrinks()) {
            System.out.printf("Drink: %s %s $%.2f\n", drink.getSize(), drink.getFlavor(), drink.getPrice());

        }

        // Total
        System.out.printf("Total: $%.2f\n", order.calculateTotal());
        System.out.println("===============================");
    }
}
