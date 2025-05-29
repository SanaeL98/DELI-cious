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




