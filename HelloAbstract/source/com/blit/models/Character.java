package com.blit.models;

public abstract class Character {

    public String name;

    public Character (String name) {
        super(); // Will be called anyways. Compiler inserts this.
        this.name = name;
    }

    // No args constructor.
    public Character () { super(); }

    // Abstract methods **force** an abstract class.
    public abstract void move (int squares, String direction);

    public double attack (double attModifier) {
        return attModifier * (Math.random()*2);
    }
}
