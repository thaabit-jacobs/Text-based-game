package net.adventure;

import net.adventure.characters.enemies.*;
import net.adventure.characters.player.Player;

public class App {
	
	public static void main(String[] args) {
		Player player = new Player("Link", 100, 15, 3);
		Enemy[] enemies = {new Skeleton("Skeleton", 60, 5, 1, 10), new Goblin("Goblin", 80, 9, 2, 5), new Zombie("Zombie", 60, 7, 1, 7), new MageGoblin("Mage Goblin", 90, 12, 3, 3), new TrollKing("Troll King", 95, 15, 3, 1)};
		int[] enemySpawnChance = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5};
		
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "************************");
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "*Welcome to the Dungeon*");
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "************************");
		
		boolean gameLoop = true;
		
		while(gameLoop) {
			break;
		}
	}
}
