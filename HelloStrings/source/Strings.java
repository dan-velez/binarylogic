/**
 * Primitives, objects, and strings.
 */

// package com.blit;

public class Strings {
    public static void main (String[] args) {
        String s = "World";
        byte b = -34;
        
        // String Concatenation.
        System.out.println("Hello".toLowerCase() + " " + s.length() + " " + b);
    
        String s1 = "Hello";
        String s2 = s1;
        char[] chars1 = {'H', 'e', 'l', 'l', 'o'};
        char[] chars2 = chars1; 

        // Both chars1 and chars2 will change the 'e'.
        chars1[1] = 'E';

        System.out.println(chars1);
        System.out.println(chars2);

        // s2 will stay the same, even if it is pointing to s1.
        // s2 is a copy.
        s1 = s1.charAt(0) + "B" + s1.substring(2);
        
        // Reassigning a string. Cannot do with **final** keyword.
        s2 = "diff string";
        
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        // Create a new string object based off 2 existing values.
        String s3 = s1.concat(s2);
        System.out.println(s3);

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String s4 = "Cat";
        char[] chars4 = {'C', 'a', 't'};

        // Different memory location. A copy.
        // NOT a string literal. (Not in string pool).
        String s5 = new String(chars4);

        // Copy memory location.
        String sx = s4;

        System.out.println("s4: " + s4);
        System.out.println("s5: " + s5);
        System.out.println("==: " + (s4 == s5));
        System.out.println(".equals: " + s4.equals(s5)); 
        System.out.println("s4 == s6: " + (s4 == sx));

        // String pool. These point to same mem location.
        String s6 = "Hello";
        String s7 = "Hello"; 

        // (Not a string literal.)
        chars2[1] = 'e';
        String s8 = new String(chars2);
        
        // == points to the string pool locations.
        System.out.println("String pool ==: " + (s6 == s7));
        System.out.println("Not String Pool: " + (s6 == s8));

        
    }
}