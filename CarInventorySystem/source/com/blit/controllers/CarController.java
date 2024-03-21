package com.blit.controllers;

import com.blit.services.CarService;
import com.blit.models.Car;

import java.util.List;
import java.util.Scanner;

public class CarController {
    private CarService carService = new CarService();
    private Scanner scan = new Scanner(System.in);
    
    public void displayCars () {
        System.out.println("What type of cars would you like to see?" +
            " Give the make, or 'ALL' for all cars.");
        String answer = scan.nextLine();

        if(answer.toUpperCase().equals("ALL")) {
            System.out.println("Here are your cars:");
            List<Car> carList = carService.seeCars();
            
            for(Car car : carList) {
                System.out.println(car);
            }
        } else {
            List<Car> carList = carService.seeCars(answer);
            for(Car car : carList) {
                System.out.println(car);
            }
        }
    }

    public void addNewCar() {
        System.out.println("What is the vin of the new car?");
        String vin = scan.nextLine();
        System.out.println("What is the make?");
        String make = scan.nextLine();
        System.out.println("What is the color?");
        String color = scan.nextLine();
        System.out.println("What is the model?");
        String model = scan.nextLine();
        int year = 0;
        while(year < 1900) {
            try {
                System.out.println("What is the year of manufacture?");
                String yearString = scan.nextLine();
                year = Integer.parseInt(yearString);
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid year."+
                " Please try again.");
            }
        }
        
        System.out.println("What is the milage of the vehicle?");
        int mileage = -1;
        while (mileage < 0) {
            try {
                mileage = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("This is not a valid milage. Try again");
            }
        }
        System.out.println("Is the car new?");
        String newCar = scan.nextLine();
        
        carService.addNewCar(vin, make, model, color, 
            year, mileage, (newCar.equalsIgnoreCase("YES")? false : true));
    }

    public void removeCar () {
        System.out.println("What is the vin of the car you would like"+
        " to remove?");
        String vin = scan.nextLine();
        carService.removeCar(vin);
        System.out.println("Car "+vin+" successfully removed.");
    }
}
