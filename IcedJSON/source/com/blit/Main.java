package com.blit;

import java.util.Map;

public class Main {
	
	public static void main (String[] args) {
		System.out.println("IcedJSON v1.0.0");
		
		Lexer ij = new Lexer();
		
		try {
			ij.parseFile("./test.json");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// try {
		// 	Map<String, Object> parsed = ij.parseFile("./test.json");
			
		// 	for (Map.Entry<String, Object> e : parsed.entrySet()) {
		// 		System.out.println(e.getKey()+" : "+e.getValue());
		// 	}
		// } catch (Exception e) {
		// 	System.out.println(e.getMessage());
		// }
	}
}