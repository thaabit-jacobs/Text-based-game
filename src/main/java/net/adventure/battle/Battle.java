package net.adventure.battle;

import java.util.Random;

import net.adventure.characters.Character;
import net.adventure.characters.enemies.*;
import net.adventure.characters.player.Player;

public class Battle {
	
	private Character player;
	
	private Character enemy;
	
	private String userInput;
	
	public Battle(Character player, String userInput) {
		
		this.player = player;
		
		this.enemy = spawnEnemy();
		
		this.userInput = userInput;
	}
	
	public String playerMove() {
		if(userInput.equalsIgnoreCase("1")) {
			player.attack(enemy);
			return player.getName() + " chose to attack";
			
		} else if(userInput.equalsIgnoreCase("2")) {
			player.block();
			return player.getName() + " chose to block";
			
		} else if(userInput.equalsIgnoreCase("3")) {
			player.heal();
			return player.getName() + " chose to heal";
			
		} else if(userInput.equalsIgnoreCase("4")) {
			Player player2 = (Player)player;
			player2.run();
			return player.getName() + " chose to run";
			
		} else {
			return "Inavlid input";
		}
	}
	
	public String enemyMove() {
		int[] chance = {1,1,1,1,1,1,2,2,2,3};
		Random r = new Random();
		int enemyInput = r.nextInt((4-1))+1;
		
		if(chance[enemyInput] == 1) {
			enemy.attack(player);
			return enemy.getName() + " chose to attack";
			
		} else if(chance[enemyInput] == 2) {
			enemy.block();
			return enemy.getName() + " chose to block";
			
		} else {
			enemy.heal();
			return enemy.getName() + " chose to heal";
		}
	}
	
	public Enemy spawnEnemy() {
		Random r = new Random();
		Enemy[] enemies = {new Skeleton("Skeleton", 60, 5, 1, 10), new Goblin("Goblin", 80, 9, 2, 5), new Zombie("Zombie", 60, 7, 1, 7), new MageGoblin("Mage Goblin", 90, 12, 3, 3), new TrollKing("Troll King", 95, 15, 3, 1)};
		int[] enemySpawnChance = {0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4};
		
		int enemyToSpawn = enemySpawnChance[r.nextInt(enemySpawnChance.length + 1)];
		
		return enemies[enemyToSpawn];
	}
	
	public void displayUI() {
		System.out.println("<1> Attack");
		System.out.println("<2> Block");
		System.out.println("<3> Heal");
		System.out.println("<4> Run");
	}
}
