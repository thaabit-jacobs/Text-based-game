package net.adventure;

import java.util.Scanner;

import net.adventure.battle.Battle;
import net.adventure.characters.enemies.*;
import net.adventure.characters.player.Player;

public class App {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Player player = new Player("Link", 100, 30, 3);
		Battle battle;
		String uc = "";
		
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "************************");
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "*Welcome to the Dungeon*");
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "************************");
		
		boolean mainGameLoop = true;
		
		MAIN:
		while(mainGameLoop) {
			battle = new Battle(player);
			Enemy enemy = battle.getEnemy();
			
			System.out.println();
			System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + player.getName() + " has encountered " + enemy.getName() + "\n");
			
			while(true) {
				System.out.println();
				battle.displayCharacterStat(player, enemy);
				
				System.out.println();
				System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "What is you next move: ");
				
				System.out.println();
				battle.displayUI();
				
				System.out.print("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "Enter: ");
				uc = sc.nextLine();
				
				System.out.println();
				battle.battlePhase(uc);
				
				if(player.getHealth() <= 0) {
					System.out.println();
					System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + player.getName() + " has been defeated...");
					break MAIN;
				}
				else if(enemy.getHealth() <= 0) {
					System.out.println();
					System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + enemy.getName() + " has been defeated...");
					System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + enemy.dropPotion(player));
					continue MAIN;
				}
			}

		}
		
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "************************");
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "*Thank you for playing*");
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "************************");
	}
}
