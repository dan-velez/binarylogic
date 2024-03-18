package com.blit.models;

public class NonPlayerCharacter extends Character {

    public boolean merchant;
    
    public NonPlayerCharacter (String name, boolean merchant) {
        super(name);
        this.merchant = merchant;
    } 

    public NonPlayerCharacter () { super(); }

    @Override
    public void move(int squares, String direction) {
        if(merchant) {
            System.out.println("Merchants cannot move. That would be rude.");
        } else {
            System.out.println(super.name+" wanders.");
        }
    }
    
}
