package com.blit.models;

import java.time.LocalDate;

import com.blit.exceptions.InvalidVinException;
import com.blit.exceptions.InvalidYearException;

public class Car {
    private String vinNumber;
    private String make;
    private String model;
    private int year;
    private String color;
    private int mileage;
    private boolean used;

    public Car (String vinNumber, String make, String model, int year, 
    String color, int mileage, boolean used) 
    throws InvalidVinException, InvalidYearException {
        super();    
        if(vinNumber == null || vinNumber.equals("")) {
            System.out.println("Invalid VIN! ["+vinNumber+"]");
            throw new InvalidVinException(
                "Tried to change vin to invalid.");
        }
        this.vinNumber = vinNumber;
        this.make = make;
        this.model = model;
        if(year < 1900 || year > LocalDate.now().getYear()+1) {
            throw new InvalidYearException("");
        }
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.used = used;
    }

    public Car () {
        super();
    }

    public String getVin () {
        return this.vinNumber;
    }
    
    public String getMake () {
        return this.make;
    }

    public String getModel () {
        return this.model;
    }

    public int getYear () {
        return this.year;
    }

    public String getColor () {
        return this.color;
    }

    public int getMileage () {
        return this.mileage;
    }

    public boolean getUsed () {
        return this.used;
    }

    public void setVin (String vin) throws InvalidVinException {
        if(vin == null || vin.equals("")) {
            throw new InvalidVinException(
                "Tried to change vin to invalid.");
        }
        this.vinNumber = vin;
    }

    public void setMake (String s) {
        this.make = s;
    } 

    public void setModel (String s) {
        this.model = s;
    } 

    public void setYear (int s) throws InvalidYearException {
        if(year < 1900 || year > LocalDate.now().getYear()+1) {
            throw new InvalidYearException(
                "Tried to set invalid year");
        }
        this.year = s;
    } 

    public void setColor (String s) {
        this.color = s;
    } 

    public void setMileage (int s) {
        this.mileage = s;
    } 

    public void setUsed (boolean s) {
        this.used = s;
    }

    public String toString () {
        return "Car ["+this.vinNumber+"] Model ["+this.model+"] "+
        "Make ["+this.make+"] Year ["+this.year+"] ";
    }
}