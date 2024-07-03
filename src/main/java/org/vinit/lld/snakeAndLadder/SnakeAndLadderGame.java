package org.vinit.lld.snakeAndLadder;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLadderGame {
    Board board;
    Queue<Player> queue;
    Player winnerPlayer;

    public SnakeAndLadderGame() {
        board = new Board();
        queue = new LinkedList<>();
        winnerPlayer = null;
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
        queue.offer(p);
    }

    public void start() {
        // start the game
    }

}
