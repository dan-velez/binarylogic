package com.blit.models;

public class Student {
    private String name;
    private int id;
    private double gpa;
    private String gender;

    public Student () { super(); }

    public Student(String name, int id, double gpa, String gender) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        this.gender = gender;
    }

    public Student(String name, double gpa, String gender) {
        this.name = name;
        this.gpa = gpa;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGpa() {
        return this.gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
