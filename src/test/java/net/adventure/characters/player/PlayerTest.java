package net.adventure.characters.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void shouldSetBlockToTrue() {
		Player p = new Player("Test", 0, 0, 0, 0);
		p.setBlock(true);
		assertEquals(true, p.getBlock());
	}
	
	@Test
	void shouldSetHealthToFifty() {
		Player p = new Player("Test", 100, 0, 0, 0);
		p.setHealth(50);
		assertEquals(50, p.getHealth());
	}
	
	@Test
	void shouldSubtractOneFromPotionCount() {
		Player p = new Player("Test", 0, 0, 0, 2);
		p.setPotion();
		assertEquals(1, p.getPotionCount());
	}
	
	@Test
	void shouldReturnAttackDamageCal() {
		Player p = new Player("Test", 0, 15, 0, 0);
		assertEquals(25, p.calculateAttackDamage());
	}
	
	@Test
	void shouldSetBlockToTrueAfterBlockCall() {
		Player p = new Player("Test", 0, 0, 0, 0);
		p.block();
		assertEquals(true, p.getBlock());
	}
	
	@Test
	void shouldAddFifteenToHealth() {
		Player p = new Player("Test", 75, 0, 0, 1);
		p.heal();
		assertEquals(90, p.getHealth());
	}

}
