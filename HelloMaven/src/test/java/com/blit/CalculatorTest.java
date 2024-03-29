package com.blit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    
    private static Calculator calc;
    private static int i;
    private static int j;
    private static int k;
    private static int result;

    @BeforeAll
    public static void createCalc () {
        System.out.println("Running createCalc()");
        calc = new Calculator();
    }

    @BeforeEach
    public void setInts () {
        System.out.println("Setting ints");
        i = 5;
        j = 7;
        k = 0;
    }

    @Test
    public void sumTest () {
        result = calc.sum(i, j);
        assertEquals(result, 12);
    }

    @Test
    public void productTest () {
        i = 7; /* Values are not reset. Applies to proceeding tests. */
        result = calc.product(i, j);
        assertTrue(result==49);
    }

    @Test
    public void divideByZeroTest () {
        System.out.println("Running divideByZeroTest()");
        // Using a lambda to tell assertion what code to run.
        // Surrounding it with try/catch for this exception.
        assertThrows(ArithmeticException.class, 
            ()-> calc.quotient(i, k)
            );
    }

    @AfterEach
    public void resetResult () {
        System.out.println("Running resetResult()");
        result = 0;
    }

    @AfterAll
    public static void releaseCalc () {
        System.out.println("Running releaseCalc()");
        calc = null;
    }

}