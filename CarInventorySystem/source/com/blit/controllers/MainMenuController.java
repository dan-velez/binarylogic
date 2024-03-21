package com.blit.controllers;

import java.util.Scanner;

public class MainMenuController {
    
    private Scanner scan = new Scanner(System.in);
    private CarController carController = new CarController();

    public void firstMenu () {
        System.out.println("Hello, welcome to your CarInventorySytem.");

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. See all cars");
            System.out.println("2. Add new car");
            System.out.println("3. Remove a car");
            System.out.println("0. Exit the application.");
    
            String answer = scan.nextLine();
            
            switch(answer) {
                case "1":
                    carController.displayCars();
                    break;
                case "2":
                    carController.addNewCar();
                    break;
                case "3":
                    carController.removeCar();
                    break;
                case "0":
                    System.out.println("Thank you for using the application!");
                    System.exit(0);
                default:
                    System.out.println("That is not a valid entry. "+
                    "Please try again.");
            }
        }
    }
}
