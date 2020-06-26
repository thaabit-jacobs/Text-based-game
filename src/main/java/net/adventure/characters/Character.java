package net.adventure.characters;

import net.adventure.characters.behaviour.Combatable;

public abstract class Character implements Combatable{
	
	private String name;
	
	private int health;
	
	private int attackStat;
	
	private int staminaStat;
	
	private int potionCount;
	
	private boolean block = false;
	
	public Character(String name, int health, int attackStat, int staminaStat, int potionCount) {
		
		this.name = name;
		
		this.health = health;
		
		this.attackStat = attackStat;
		
		this.staminaStat = staminaStat;
		
		this.potionCount = potionCount;
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getAttackStat() {
		return attackStat;
	}
	
	public int getStamina() {
		return staminaStat;
	}
	
	public int getPotionCount() {
		return potionCount;
	}
	
	public boolean getBlock() {
		return block;
	}
	
	public void setBlock(boolean b) {
		block = b;
	}
	
	public void setHealth(int damage) {
		health -= damage;
	}
	
	public void setPotion() {
		potionCount--;
	}
	
	public int calculateAttackDamage() {
		return attackStat + 10;
	}
	
	public boolean block() {
		this.setBlock(true);
		return this.getBlock();
	}
	
	public String heal() {
		if(potionCount <= 0)
			return "Out of potions";
		
		setPotion();
		health += 15;
		
		return "Used potion";
	}
	
	public String toString() {
		return name + "\n" + "health: " + health + "\n" + "potions: " + potionCount;
	}
}
