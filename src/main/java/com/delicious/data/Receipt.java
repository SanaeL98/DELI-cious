package com.delicious.data;

import com.delicious.model.*;

import com.delicious.model.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private Order order;

    public Receipt(Order order) {
        this.order = order; // when the receipt object is created, it receives an order object and saves it
    }

    public void printReceipt() {
        System.out.println("\n====== DELI-cious Receipt ======");

        // Date/Time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' h:mm a");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Order Date/Time: " + dtf.format(now));
        System.out.println();

        // Sandwiches
        for (Sandwich sandwich : order.getSandwiches()) {  //repeat actions for each item in the list
            System.out.print("Sandwich: ");
            System.out.printf("%s Bread", sandwich.getBread());  //to prints text with format placeholders

            for (Topping topping : sandwich.getToppings()) {
                if (topping instanceof Meat) {
                    System.out.print(" with " + topping.getName());
                    break;
                }
            }

            System.out.printf("  $%.2f\n", sandwich.calculatePrice());

            System.out.print("Toppings: ");
            boolean first = true; // start of the loop
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


            // Chips
            for (Chips chip : order.getChips()) {  //loop through each chip the customer added+ returnz the list of chips from the order
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

    public static void saveOrderToFile(Order order) {
        try {
            File dir = new File("receipts");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String fileName = "receipts/" + timestamp + ".txt";

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write("===== DELI-cious Receipt =====\n\n");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' h:mm a");
            LocalDateTime now = LocalDateTime.now();
            writer.write("Order Date/Time: " + dtf.format(now) + "\n\n");

            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write(String.format("Sandwich: %s Bread, size %s, toasted: %s\n",
                        sandwich.getBread(), sandwich.getSize(), sandwich.isToasted()));

                writer.write("Meat: ");
                for (Topping topping : sandwich.getToppings()) {
                    if (topping instanceof Meat) {
                        writer.write(topping.getName() + "\n");
                        break;
                    }
                }
                writer.write("Toppings: ");
                boolean first = true;
                for (Topping topping : sandwich.getToppings()) {
                    if (!(topping instanceof Meat || topping instanceof Cheese)) {
                        if (!first) writer.write(", ");
                        writer.write(topping.getName());
                        first = false;
                    }
                }
                writer.write("\n");

                writer.write("Cheese: ");
                for (Topping topping : sandwich.getToppings()) {
                    if (topping instanceof Cheese) {
                        writer.write(topping.getName());
                    }
                }
                writer.write("\n");

                writer.write(String.format("Subtotal: $%.2f\n\n", sandwich.calculatePrice()));
            }

            for (Chips chip : order.getChips()) {
                writer.write(String.format("Chips: %s - $%.2f\n", chip.getFlavor(), chip.getPrice()));
            }

            for (Drink drink : order.getDrinks()) {
                writer.write(String.format("Drink: %s %s - $%.2f\n", drink.getSize(), drink.getFlavor(), drink.getPrice()));
            }
            writer.write(String.format("\nTotal: $%.2f\n", order.calculateTotal()));
            writer.write("==============================\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
