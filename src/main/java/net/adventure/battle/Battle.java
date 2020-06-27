package net.adventure.battle;

import java.util.Random;

import net.adventure.characters.Character;

import net.adventure.characters.player.Player;

public class Battle {
	
	private Character player;
	
	private Character enemy;
	
	private String userInput;
	
	public Battle(Character player, Character enemy, String userInput) {
		
		this.player = player;
		
		this.enemy = enemy;
		
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
	
	public void displayUI() {
		System.out.println("<1> Attack");
		System.out.println("<2> Block");
		System.out.println("<3> Heal");
		System.out.println("<4> Run");
	}
}
