package net.adventure.characters.player;

import java.util.Random;

import net.adventure.characters.Character;

public class Player extends Character{
	
	public Player(String name, int health, int attackStat, int potionCount) {
		super(name, health, attackStat, potionCount);
	}
	
	public String attack(Character enemy) {
		if(enemy.getBlock()) {
			enemy.setHealth((int)(this.calculateAttackDamage() * 0.25));
			enemy.setBlock(false);
			return this.getName() + " inflicted " + (int)(this.calculateAttackDamage() * 0.25) + " damage";
		}
		
		enemy.setHealth((int)(this.calculateAttackDamage()));
		return this.getName() + " inflicted " + (int)(this.calculateAttackDamage()) + " damage";
	}
	
}
