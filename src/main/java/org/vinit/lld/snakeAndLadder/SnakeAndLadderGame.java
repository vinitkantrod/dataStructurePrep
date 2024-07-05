package org.vinit.lld.snakeAndLadder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLadderGame {
    Board board;
    Queue<Player> queue;
    Player winnerPlayer;
    Dice dice;
    Map<Player, Integer> playerPosition;

    public SnakeAndLadderGame() {
        board = new Board();
        queue = new LinkedList<>();
        winnerPlayer = null;
        dice = new Dice();
        playerPosition = new HashMap<>();
    }

    public void addSnake(int x, int y) {
        board.addSnake(x, y);
    }
    public void addLadder(int x, int y) {
        board.addLadder(x, y);
    }

    public void addPlayer(String playerName) {
        Integer id = Player.generateId();
        Player p = new Player(id, playerName);
        playerPosition.put(p, 0);
        queue.offer(p);
    }

    public void start() {
        // start the game
        while (!isGameOver()) {
            Player nextPlayer = queue.poll();
            Integer rollValue = dice.roll();
            Integer prevPos = playerPosition.get(nextPlayer);
            Integer nextEnd = playerPosition.get(nextPlayer) + rollValue;
            if (isValidPos(nextEnd)) {
                if (board.isSnakeExist(nextEnd)) {
                    nextEnd = board.snakes.get(nextEnd);
                } else if (board.isLadderExist(nextEnd)) {
                    nextEnd = board.ladders.get(nextEnd);
                }
                if (isWinningPosition(nextEnd)) {
                    winnerPlayer = nextPlayer;
                }
                playerPosition.put(nextPlayer, nextEnd);
                System.out.println("Player " + nextPlayer.name + " rolled " +
                        rollValue + " and moved from " + prevPos + " to " + nextEnd);
            } else {
                System.out.println("Player " + nextPlayer.name + " rolled " +
                        rollValue + " but cannot move as the pos is invalid.");
            }
            queue.offer(nextPlayer);
        }
        System.out.println("\n ----------------------------------------------------- \n");
        System.out.println("\t *** Player " + winnerPlayer.name + " won the game! ***");
        System.out.println("\n ----------------------------------------------------- \n");
    }

    private boolean isWinningPosition(int pos) {
        return pos == 100;
    }
    private boolean isValidPos(int pos) {
        return pos <= 100;
    }


    private boolean isGameOver() {
        return winnerPlayer != null;
    }

}
