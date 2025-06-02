package com.delicious;

import com.delicious.ui.UserInterface;

public class Program {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();  // prepare the app to show the menu and start interacting with the user
        ui.start();  // let the user place the order
    }
}
