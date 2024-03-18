package com.blit.models;

public class PlayerCharacter extends Character implements Damageable {

    public int hitPoints;
    
    public PlayerCharacter (String name, int hitPoints) {
        super(name);
        this.hitPoints = hitPoints;
    }

    @Override
    public void move (int squares, String direction) {
        System.out.println(super.name+" walk "+squares+" squares to the "+
        direction);
    }

    public void victorySpeech (String monsterName) {
        System.out.println(super.name+" shouts: I defeated the "+monsterName);
    }

    @Override
    public void takesDamage(double damageTaken) {
        this.hitPoints -= (int)damageTaken;
        if(this.hitPoints < 1) {
            System.out.println(super.name+" is dead.");
        } else {
            
        }
    }
}
