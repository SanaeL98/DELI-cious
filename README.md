# DELI-cious - Capstone 2 (Java CLI App)

This is a custom sandwich ordering system built in Java using object-oriented principles.

## Features
- Add sandwich, drink, chips
- View receipt
- Calculate total price
- Topping and size-based pricing

## Screenshots
![Screen1](https://github.com/user-attachments/assets/bb4a6b34-61c3-4a7a-be93-d2101f0df798)
![Screen2](https://github.com/user-attachments/assets/d9d25dc5-8ab7-4741-9fe2-ca75c24db61a)
![Screen3](https://github.com/user-attachments/assets/ea9d7034-fd13-4873-867f-015f501f2533)

## Interesting Code
```java
public void calculatePrice() {
    double total = basePrice;
    for (Topping topping : toppings) {
        total += topping.getPrice();
    }
    this.price = total;
}

## UML Diagram Explanation
This UML diagram shows how my sandwich ordering program is organized.
The main class is Order, which holds a list of sandwiches, drinks, and chips. Each Sandwich has a bread type, size, and toppings like Meat, Cheese, and other Toppings.
The Meat and Cheese classes come from a base class called Topping, which helps keep the code organized and reusable.
The Drink and Chips classes hold the flavor and price for each item.
The Receipt class is used to print the order details, and the UserInterface class manages the user’s input and guides them through the process.
 This structure helps the app stay clean and easy to update.

![finalDiagram](https://github.com/user-attachments/assets/e522243a-2f39-4a3f-8549-1179b655b27e)


