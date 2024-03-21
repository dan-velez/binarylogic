package com.blit;

import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Map;

public class Main {
	public static void main (String[] args) {
		System.out.println("About to throw an unchecked exception");
		
		try {
			if(Math.random() > 0.5) {
				throwUnchecked();
			}
			System.out.println("Code ran normally.");
			throw new Exception();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("I am in the finally block.");
		}

		// new StringReader("String").read();

		try {
			if(Math.random() > 0.5) throwChecked();
			System.out.println("Second try code worked fine.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("EOF");
	}

	public static void throwUnchecked () {
		throw new RuntimeException("This is a message");
	}

	public static void throwChecked () throws FileNotFoundException {
		// Dont need try catch HERE because the method 'throws' exception.
		throw new FileNotFoundException();
	}
}