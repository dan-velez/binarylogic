package com.blit.models;

import java.time.LocalDate;

public class Person {
    public String name;
    private short age;
    public LocalDate dateOfBirth;
    public boolean married;

    public void walk (int steps) {
        System.out.println(name + " walks " + steps + " steps forward.");
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