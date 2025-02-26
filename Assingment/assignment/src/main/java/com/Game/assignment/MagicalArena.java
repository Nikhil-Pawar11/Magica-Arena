package com.Game.assignment;

public class MagicalArena {
    public void attack(Player attacker, Player defender, int diceRoll) {
        int damage = Math.max(0, diceRoll + attacker.getAttack() - defender.getDefense());
        defender.setHealth(defender.getHealth() - damage);
    }

    public boolean isGameOver(Player playerA, Player playerB) {
        return playerA.getHealth() <= 0 || playerB.getHealth() <= 0;
    }

    public String getWinner(Player playerA, Player playerB) {
        if (playerA.getHealth() > 0) {
            return playerA.getName();
        } else if (playerB.getHealth() > 0) {
            return playerB.getName();
        }
        return "Draw";
    }
}
