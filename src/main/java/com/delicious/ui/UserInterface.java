package com.delicious.ui;

import com.delicious.model.*;
import com.delicious.model.Order;
import com.delicious.data.Receipt;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Order order;

    public void start() {
        while (true) {
            System.out.println("\n====== DELI-cious Menu ======");
            System.out.println("1. New Order");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                startNewOrder();
            } else if (choice == 2) {
                System.out.println("Thank you for visiting DELI-cious!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void startNewOrder() {
        order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n---- New Order ----");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. View Receipt");
            System.out.println("5. Finish Order");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addSandwich();
                case 2 -> addDrink();
                case 3 -> addChips();
                case 4 -> new Receipt(order).printReceipt();
                case 5 -> {
                    System.out.println("Order completed.");
                    new Receipt(order).printReceipt();
                    Receipt.saveOrderToFile(order);
                    ordering = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addSandwich() {
        System.out.print("Enter sandwich size (4/8/12 inches): ");
        String sizeInput = scanner.nextLine().trim();
        String size = switch (sizeInput) {
            case "4" -> "Small";
            case "8" -> "Medium";
            case "12" -> "Large";
            default -> {
                System.out.println("Invalid size. Defaulting to Medium.");
                yield "Medium";  //yield is used inside a switch expression to give back a result
            }
        };

        System.out.println("Choose bread type:");
        System.out.println("1. White");
        System.out.println("2. Wheat");
        System.out.println("3. Rye");
        System.out.println("4. Wrap");
        String bread = switch (scanner.nextLine().trim()) {
            case "1" -> "White";
            case "2" -> "Wheat";
            case "3" -> "Rye";
            case "4" -> "Wrap";
            default -> {
                System.out.println("Invalid choice. Defaulting to Wheat.");
                yield "Wheat";
            }
        };

        boolean toasted = askYesNo("Toasted?");

        Sandwich sandwich = new CustomSandwich(size, bread, toasted);

        System.out.println("Choose meat:");
        System.out.println("1. Steak\n2. Ham\n3. Salami\n4. Roast Beef\n5. Chicken\n6. Bacon");
        String meatFlavor = switch (scanner.nextLine().trim()) {
            case "1" -> "Steak";
            case "2" -> "Ham";
            case "3" -> "Salami";
            case "4" -> "Roast Beef";
            case "5" -> "Chicken";
            case "6" -> "Bacon";
            default -> {
                System.out.println("Invalid meat. Defaulting to Chicken.");
                yield "Chicken";
            }
        };

        boolean extraMeat = askYesNo("Add extra meat?");
        sandwich.addTopping(new Meat(meatFlavor, 1.50, extraMeat));

        System.out.println("Choose cheese:");
        System.out.println("1. American\n2. Provolone\n3. Cheddar\n4. Swiss");
        String cheeseFlavor = switch (scanner.nextLine().trim()) {
            case "1" -> "American";
            case "2" -> "Provolone";
            case "3" -> "Cheddar";
            case "4" -> "Swiss";
            default -> {
                System.out.println("Invalid cheese. Defaulting to Cheddar.");
                yield "Cheddar";
            }
        };

        boolean extraCheese = askYesNo("Add extra cheese?");
        sandwich.addTopping(new Cheese(cheeseFlavor, 1.00, extraCheese));

        addRegularToppings(sandwich);

        order.addSandwich(sandwich);
        System.out.println("Sandwich added!");
    }

    private void addRegularToppings(Sandwich sandwich) {
        System.out.println("Add regular toppings (type 'done' to finish):");
        System.out.println("- lettuce, peppers, onions, tomatoes, jalapeños");
        System.out.println("- cucumbers, pickles, guacamole, mushrooms");

        while (true) {
            System.out.print("Topping name: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("done")) break;

            String toppingName = input.substring(0, 1).toUpperCase() + input.substring(1);
            sandwich.addTopping(new Topping(toppingName, 0.00));
            System.out.println(toppingName + " added.");
        }
    }

    private void addDrink() {
        System.out.print("Enter drink flavor: ");
        String flavor = scanner.nextLine();

        System.out.println("Choose size:");
        System.out.println("1. Small ($2.00)");
        System.out.println("2. Medium ($2.50)");
        System.out.println("3. Large ($3.00)");
        String size = switch (scanner.nextLine().trim()) {
            case "2" -> "Medium";
            case "3" -> "Large";
            default -> "Small";
        };

        boolean extra = askYesNo("Add extra?");
        order.addDrink(new Drink(flavor, size, extra));
        System.out.println("Drink added!");
    }


    private void addChips() {
        System.out.print("Enter chips flavor: ");
        String flavor = scanner.nextLine();

        order.addChips(new Chips(flavor, 1.50));
        System.out.println("Chips added!");
    }

    private boolean askYesNo(String prompt) {   // utility method used to get a yes/no from the user
        System.out.print(prompt + " (yes/no): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("yes");
    }
}
