package com.blit.models;

public class Sprinter extends Person {

    @Override
    public void walk (int steps, String dir) {
        System.out.println(super.name+" sprints "+steps+" steps very quickly"
        +" in the direction of "+dir);
    }   

    public void walk (String direction, int steps) {
        // Diff signature, not overriden.
        System.out.println(super.name +" sprints "+ steps +" "+ direction 
        + " closer to the finish line.");
    }
} 