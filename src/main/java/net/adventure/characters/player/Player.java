package net.adventure.characters.player;

import java.util.Random;

import net.adventure.characters.Character;
import net.adventure.characters.behaviour.Escapable;

public class Player extends Character implements Escapable{
	
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
	
	public boolean run() {
		Random r = new Random();
		
		if(r.nextInt(2) == 0) {
			System.out.println("Unable to ran away...");
			return false;
		}
		
		return true;
	}
	
}
