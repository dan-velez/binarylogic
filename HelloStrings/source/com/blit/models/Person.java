package com.blit.models;

import java.time.LocalDate;

public class Person {
    public String name;
    private short age;
    public LocalDate dateOfBirth;
    public boolean married;

    public Person () {
        super();
    }

    public Person (String name, short age) {
        super(); // If you do not include call, the compiler will add it.
        this.name = name;
        if(age >= 0) { this.age = age; }
    }

    public Person (String name, short age, LocalDate dateOfBirth, 
    boolean married) {
        this(name, age);
        this.dateOfBirth = dateOfBirth;
        this.married = married;
    }

    public void walk (int steps, String dir) {
        System.out.println(name + " walks " + steps + " steps "+dir+".");
    }

    public int getAge () {
        return this.age;
    }

    public void setAge (short newAge) {
        if(newAge >= 0) {
            this.age = newAge;
        }
    }
}