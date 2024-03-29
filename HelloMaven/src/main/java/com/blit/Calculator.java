package com.blit;

public class Calculator {
    
    public int sum (int i, int j) {
        return i + j;
    }

    public int product (int i, int j) {
        return i * j;
    }

    public int quotient (int i, int j) {
        if(j == 0) {
            throw new ArithmeticException();
        }
        return i / j;
    }

}
