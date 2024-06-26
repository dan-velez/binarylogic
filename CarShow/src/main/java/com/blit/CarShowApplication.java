package com.blit;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.blit.entity.Car;
import com.blit.entity.Owner;
import com.blit.repository.CarRepository;
import com.blit.repository.OwnerRepository;

@SpringBootApplication
// @ComponentScan(basePackages = "com.blit.repository")
// @EnableJpaRepositories("com.blit.repository")
public class CarShowApplication implements CommandLineRunner {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	private static final Logger logger = LoggerFactory.getLogger(
		CarShowApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarShowApplication.class, args);
		logger.info("Application Started...");
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("John", "Doe");
		Owner owner2 = new Owner("Jack", "Biden");
		this.ownerRepository.saveAll(Arrays.asList(owner1, owner2));

		List<Car> cars = Arrays.asList(
			new Car("Ford", "Mustang", 
				"Red", "ADF_112", 2021, 49000),
			
			new Car("Nissan", "Leaf", 
				"Gray", "EBF_122", 2020, 32500),
			
			new Car("Toyota", "Camry", 
			"Silver", "CDF_3123", 2021, 32000),

			new Car("Toyota", "Corolla", "White",
				"DDF_3421", 2023, 40000)
		);
		
		carRepository.saveAll(cars);
		carRepository.findAll().forEach(
			car -> logger.info(car.getBrand()+" "+car.getModel()));
	}

}
