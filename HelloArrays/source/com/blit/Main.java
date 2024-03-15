package com.blit;

public class Main {
    public static void main (String[] args) {
        int[] ints = new int[3]; // [0, 0, 0].
        for(int i = 0; i < ints.length; ++i) {
            System.out.println(ints[i]);
        }

        char[] chars = new char[3]; // Empty chars. Blank.
        for(int i = 0; i < chars.length; i++) {
            System.out.println("["+chars[i]+"]");
        }

        String[] strings = new String[4]; // null objects.
        System.out.println(strings);
        for(int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    
        for(int i = 0; i < ints.length; ++i) {
            // Force to int will floor it (round down).
            ints[i] = (int)(Math.random()*10); 
        }

        for(int i = 0; i < ints.length; ++i) {
            System.out.println(ints[i]);
        }

        int[] ints2 = {4, 5, 9, 123, -23};
        for(int i = 0; i < ints2.length; ++i) {
            System.out.println(ints2[i]);
        }

        String[] strings2 = {"Hello", "World", "", "Whatever"};
        
        ints[2] = 34; // Can change values of array indexes.

        // Multi dimensional arrays.
        int[][] matrix = new int[3][2];
        int[][] matrix2 = {{1, 2}, {3, 4}, {5, 6}};

        // int[2][2][3]
        int[][][] matrix3 = {{{1, 2, 3}, {3, 4, 5}}, {{5, 6, 7}, {7, 8, 9}}};

        int[] ints3 = {4, 5, 6, 32, 53, 64, 3};
        ints = ints3; // Change pointer.

        System.out.println("Matrix3: " + matrix3[1][0][2]);
        System.out.println("Matrix2: " + matrix2[0][1]);
    }
}
