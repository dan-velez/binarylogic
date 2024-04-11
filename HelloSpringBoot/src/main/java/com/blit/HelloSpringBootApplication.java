package com.blit;

/**
 * Traditionally, each object is responsible for obtaining its own references
 * to the objects it collaborates with (dependencies). When using DI, objects
 * are given their dependencies at creation time by some external entity that
 * coordinates each object in the system. Objects are injected into others.
 * 
 * It delivers "loose coupling". Objects can be added and tested independantly.
 * They dont depend on anything other than what you pass to them. Its possible
 * to test the object in isolation.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}

}
