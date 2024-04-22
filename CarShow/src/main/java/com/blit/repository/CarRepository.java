package com.blit.repository;

import java.util.List;

import com.blit.entity.Car;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findCarByBrand(String brand);
    List<Car> findCarByColor(String color);
    List<Car> findCarByYear(int year);
    List<Car> findCarByBrandAndModel(String brand, String model);
    List<Car> findCarByBrandOrderByYearAsc(String brand);
}