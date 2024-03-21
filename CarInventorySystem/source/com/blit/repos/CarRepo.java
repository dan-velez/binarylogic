/**
 * Represents the Cars databaes for application.
 */
package com.blit.repos;

import java.util.ArrayList;
import java.util.List;

import com.blit.models.Car;

public class CarRepo {
    private static List<Car> carList = new ArrayList<>();
    
    public CarRepo () {
        super();
        try {
            if(carList.size() == 0) {
                // Setup the initial repo.
                carList.add(new Car(
                    "1234asdfsdfsdf",
                    "Toyota", "Corolla", 
                    2015, "Red", 
                    45_000, true));

                carList.add(new Car(
                "12lahsdkjasd",
                    "Toyota", "Camrey", 
                    2005, "Black", 
                    105_000, true));

                carList.add(new Car(
                    "12314asdakjsd",
                        "Nissan", "Maxima", 
                        2024, "Blue", 
                        15, false));
            
                carList.add(new Car(
                    "123kjasda",
                        "Subaru", "WRX", 
                        2023, "Silver", 
                        20, false));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Car> seeAllCars () {
        return carList;
    }

    public void addNewCar (Car car) {
        carList.add(car);
    }

    public void removeCar (String vin) {
        Car car = null;
        for (Car c : carList) {
            if(c.getVin().equals(vin)) {
                car = c;
                break;
            }
        }
        carList.remove(car);
    }
}
