package com.blit.models;

// Allows to be written to file.
import java.io.Serializable;

public class TreasureChest implements Damageable, Serializable {
    public double durability;
    public int gold;

    public TreasureChest (double durability, int gold) {
        super();
        this.durability = durability;
        this.gold = gold;
    }

    @Override
    public void takesDamage(double damageTaken) {
        System.out.println("Someone is breaking open the chest.");
        this.durability -= damageTaken;
        if(this.durability <= 0) {
            System.out.println("The hero found "+gold+
            " gold coins in the chest");
        }
    }
}
