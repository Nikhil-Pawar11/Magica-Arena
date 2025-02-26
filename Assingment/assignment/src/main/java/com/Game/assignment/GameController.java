package com.Game.assignment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private final Player playerA = new Player("Player A", 100, 20, 10);
    private final Player playerB = new Player("Player B", 100, 15, 12);
    private final MagicalArena arena = new MagicalArena();

    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> gameStatus() {
        Map<String, Object> response = new HashMap<>();
        response.put("playerA", Map.of(
            "name", playerA.getName(),
            "health", playerA.getHealth(),
            "attack", playerA.getAttack(),
            "defense", playerA.getDefense()
        ));
        response.put("playerB", Map.of(
            "name", playerB.getName(),
            "health", playerB.getHealth(),
            "attack", playerB.getAttack(),
            "defense", playerB.getDefense()
        ));
        response.put("gameOver", arena.isGameOver(playerA, playerB));
        response.put("winner", arena.isGameOver(playerA, playerB) ? arena.getWinner(playerA, playerB) : null);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/attack")
    public ResponseEntity<Map<String, Object>> attack(@RequestParam String attacker, @RequestParam int diceRoll) {
        Map<String, Object> response = new HashMap<>();

        if (arena.isGameOver(playerA, playerB)) {
            response.put("message", "Game is already over!");
            response.put("winner", arena.getWinner(playerA, playerB));
            return ResponseEntity.ok(response);
        }

        Player attackerPlayer;
        Player defenderPlayer;

        if ("A".equalsIgnoreCase(attacker)) {
            attackerPlayer = playerA;
            defenderPlayer = playerB;
        } else if ("B".equalsIgnoreCase(attacker)) {
            attackerPlayer = playerB;
            defenderPlayer = playerA;
        } else {
            response.put("message", "Invalid attacker! Use 'A' or 'B'.");
            return ResponseEntity.badRequest().body(response);
        }

        arena.attack(attackerPlayer, defenderPlayer, diceRoll);

        response.put("message", String.format("Player %s attacks Player %s with a roll of %d. Remaining health of defender: %d.",
                attackerPlayer.getName(), defenderPlayer.getName(), diceRoll, defenderPlayer.getHealth()));
        response.put("playerA", Map.of(
            "name", playerA.getName(),
            "health", playerA.getHealth(),
            "attack", playerA.getAttack(),
            "defense", playerA.getDefense()
        ));
        response.put("playerB", Map.of(
            "name", playerB.getName(),
            "health", playerB.getHealth(),
            "attack", playerB.getAttack(),
            "defense", playerB.getDefense()
        ));

        return ResponseEntity.ok(response);
    }
}
