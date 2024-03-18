package com.blit.models;

public class Monster extends Character implements Damageable {
    public double health;

    public Monster (String name, double health) {
        super(name);
        this.health = health;
    }

    public Monster () { super(); }

    @Override
    public void move(int squares, String direction) {
        System.out.println("The "+super.name+" slither towards the "+direction);
    }

    @Override
    public double attack (double modifier) {
        return Math.random()*10*modifier;
    }

    @Override
    public void takesDamage(double damageTaken) {
        this.health -= (int)damageTaken;
        if(this.health < 1) {
            System.out.println(super.name+" is defeated!");
        } else {
            
        }
    }
}
