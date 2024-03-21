package com.blit.services;

import com.blit.repos.CarRepo;
import com.blit.exceptions.InvalidVinException;
import com.blit.exceptions.InvalidYearException;
import com.blit.models.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private CarRepo carRepo = new CarRepo();
    
    public List<Car> seeCars () {
        List<Car> carList = carRepo.seeAllCars();
        return carList;
    }

    public List<Car> seeCars(String make) {
        List<Car> carList = carRepo.seeAllCars();
        List<Car> subList = new ArrayList();
        for(Car car : carList) {
            if(make.equalsIgnoreCase(car.getMake())) {
                subList.add(car);
            }
        }
        return subList;
    }

    public void addNewCar(String vin, String make, String model, String color, 
    int year, int mileage, boolean used) {
        try {
            Car car = new Car(vin, make, model, year, color, mileage, used);
            carRepo.addNewCar(car);
        } catch (InvalidYearException e) {
            System.out.println("Invalid year, car could not be added.");
        } catch (InvalidVinException e) {
            System.out.println("Invalid vin, car could not be added.");
        }
    }

    public void removeCar (String vin) {
        carRepo.removeCar(vin);
    }
}
