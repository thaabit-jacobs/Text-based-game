package net.adventure.characters.enemies;

import net.adventure.characters.behaviour.Dropable;

import java.util.Random;

import net.adventure.characters.Character;

public class Enemy extends Character implements Dropable{
	
	private int dropChance;
	
	public Enemy(String name, int health, int attackStat, int potionCount, int dropChance) {
		
		super(name, health, attackStat, potionCount);
		
		this.dropChance = dropChance;
		
	}

	public String attack(Character player) {
		if(player.getBlock()) {
			player.setHealth((int)(this.calculateAttackDamage() * 0.25));
			player.setBlock(false);
			return this.getName() + " inflicted " + (int)(this.calculateAttackDamage() * 0.25) + " damage";
		}
		
		player.setHealth((int)(this.calculateAttackDamage()));
		return this.getName() + " inflicted " + (int)(this.calculateAttackDamage()) + " damage";
	}
	
	
	public String dropPotion(Character player) {
		Random r = new Random();
		
		if(((r.nextInt(dropChance) + 1) == dropChance)) {
			if(this.getPotionCount() > 0) {
				this.setPotion();
				player.addPotion();
				
				return this.getName() + " dropped potion";
				
			} else
				return "No potions availible";
		}
		
		return "No potion dropped";
	}
}
