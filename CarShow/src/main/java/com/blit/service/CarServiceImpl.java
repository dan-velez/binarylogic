package com.blit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.blit.entity.Car;
import com.blit.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getCars() {
        return (List<Car>)this.carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            return car.get();
        } else {
            throw new ResourceNotFoundException(
                "Car "+id+" does not exist");
        }
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }
}