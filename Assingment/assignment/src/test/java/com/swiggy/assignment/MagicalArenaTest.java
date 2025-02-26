package com.Game.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MagicalArenaTest {

    private MagicalArena arena;
    private Player playerA;
    private Player playerB;

    @BeforeEach
    public void setUp() {
        arena = new MagicalArena();
        playerA = new Player("Player A", 100, 20, 10);  // 100 health, 20 attack, 10 defense
        playerB = new Player("Player B", 100, 15, 12);  // 100 health, 15 attack, 12 defense
    }

    @Test
    public void testAttack() {
        // Player A attacks Player B with dice roll of 5
        arena.attack(playerA, playerB, 5);
        // Player B should lose 13 health (5 + 20 - 12 = 13)
        assertEquals(87, playerB.getHealth(), "Player B should lose 13 health after Player A's attack.");
        
        // Player B attacks Player A with dice roll of 4
        arena.attack(playerB, playerA, 4);
        // Player A should lose 9 health (4 + 15 - 10 = 9)
        assertEquals(91, playerA.getHealth(), "Player A should lose 9 health after Player B's attack.");
    }

    @Test
    public void testIsGameOver() {
        // Initially, game should not be over
        assertFalse(arena.isGameOver(playerA, playerB), "Game should not be over initially.");

        // Simulate a game over situation
        playerA.setHealth(0);
        assertTrue(arena.isGameOver(playerA, playerB), "Game should be over when a player's health reaches 0.");
    }

    @Test
    public void testGetWinner() {
        // Player A wins
        playerB.setHealth(0);
        assertEquals("Player A", arena.getWinner(playerA, playerB), "Player A should be the winner.");

        // Draw situation
        playerA.setHealth(0);
        playerB.setHealth(0);
        assertEquals("Draw", arena.getWinner(playerA, playerB), "The game should result in a draw if both players' health is 0.");
    }
}
