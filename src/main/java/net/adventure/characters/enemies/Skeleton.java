package net.adventure.characters.enemies;

public class Skeleton extends Enemy{
	
	public Skeleton(String name, int health, int attackStat, int potionCount, int dropChance) {
		super("Skeleton", 60, 5, 1, 10);
	}
}
