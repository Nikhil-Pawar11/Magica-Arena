package com.Game.assignment;

public class Player {
    private String name;
    private int health;
    private int attack;
    private int defense;

    public Player(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, health); // Prevent negative health
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }
}
