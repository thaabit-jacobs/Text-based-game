package net.adventure.characters.enemies;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EnemyTest {

	@Test
	void shouldReturnNoPotionsAvailible() {
		Enemy enemy = new Enemy("Test", 0, 0, 0, 2);
		
		assertEquals(true, enemy.dropPotion(enemy).equalsIgnoreCase("No potions availible"));
	}

}
