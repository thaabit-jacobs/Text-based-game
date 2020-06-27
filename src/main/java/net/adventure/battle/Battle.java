package net.adventure.battle;

import java.util.Random;

import net.adventure.characters.Character;
import net.adventure.characters.enemies.*;
import net.adventure.characters.player.Player;

public class Battle {
	
	private Character player;
	
	private Character enemy;
	
	public Battle(Character player) {
		
		this.player = player;
		
		this.enemy = spawnEnemy();

	}
	
	public String playerMove(String userInput) {
		if(userInput.equalsIgnoreCase("1")) {
			player.attack(enemy);
			return player.getName() + " chose to attack";
			
		} else if(userInput.equalsIgnoreCase("2")) {
			player.block();
			return player.getName() + " chose to block";
			
		} else if(userInput.equalsIgnoreCase("3")) {
			player.heal();
			return player.getName() + " chose to heal";
			
		}  else {
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
	
	public void battlePhase(String userInput) {
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + playerMove(userInput));
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + enemyMove());
	}
	
	public Enemy spawnEnemy() {
		Random r = new Random();
		Enemy[] enemies = {new Skeleton("Skeleton", 60, 5, 1, 10), new Goblin("Goblin", 80, 9, 2, 5), new Zombie("Zombie", 60, 7, 1, 7), new MageGoblin("Mage Goblin", 90, 12, 3, 3), new TrollKing("Troll King", 95, 15, 3, 1)};
		int[] enemySpawnChance = {0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4};
		
		int enemyToSpawn = enemySpawnChance[r.nextInt(enemySpawnChance.length - 1) + 1];
		
		return enemies[enemyToSpawn];
	}
	
	public void displayUI() {
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "<1> Attack");
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "<2> Block");
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "<3> Heal");
	}
	
	public void displayCharacterStat(Player play, Enemy ene) {
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "Name " + play.getName() + "\t" + "Name " + ene.getName());
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "Health " + play.getHealth() + "\t" + "Health " + ene.getHealth());
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "Potions " + play.getPotionCount() + "\t" + "Potions " + ene.getPotionCount());
	}
	
	public Enemy getEnemy() {
		return (Enemy)enemy;
	}
}
