package com.blit.service;

import java.util.List;

import com.blit.entity.Car;

public interface CarService {
    List<Car> getCars();
    Car getCarById(Long id);
    Car saveCar(Car car);
}
