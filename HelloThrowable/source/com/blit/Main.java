package com.blit;

public class Main {
	public static void main (String[] args) {
		System.out.println("About to throw an unchecked exception");
		throwUnchecked();
		System.out.println("EOF");
	}

	public static void throwUnchecked () {
		throw new RuntimeException("This is a message");
	}
}