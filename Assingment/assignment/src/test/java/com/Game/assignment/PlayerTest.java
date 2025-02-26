package com.Game.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("Player A", 100, 20, 10);
    }

    @Test
    public void testGetName() {
        assertEquals("Player A", player.getName(), "Player's name should be 'Player A'.");
    }

    @Test
    public void testGetHealth() {
        assertEquals(100, player.getHealth(), "Player's health should be 100.");
    }

    @Test
    public void testSetHealth() {
        player.setHealth(80);
        assertEquals(80, player.getHealth(), "Player's health should be updated to 80.");
    }

    @Test
    public void testGetAttack() {
        assertEquals(20, player.getAttack(), "Player's attack value should be 20.");
    }

    @Test
    public void testGetDefense() {
        assertEquals(10, player.getDefense(), "Player's defense value should be 10.");
    }
}
