package com.blit;

import com.blit.models.Monster;
import com.blit.models.PlayerCharacter;
import com.blit.models.TreasureChest;

public class Main {
	public static void main (String[] args) {
		System.out.println("Hello, abstract classes!");
		
		PlayerCharacter player = new PlayerCharacter("fighter1", 
		5);
		Monster monster = new Monster("Yaun-ti", 12);
		
		player.move(12, "Left");
		monster.move(4, "Right");

		System.out.println("Player damage: "+player.attack(10));
		System.out.println("Monster damage: "+monster.attack(4));

		while(monster.health > 0 && player.hitPoints > 0) {
			monster.takesDamage(player.attack(7));
			player.takesDamage(monster.attack(3));
		}

		if(player.hitPoints > 0) {
			TreasureChest chest = new TreasureChest(
			20.0, (int)Math.random() *300);
			while(chest.durability > 0) {
				chest.takesDamage(player.attack(10));
			}
		}
	}
}