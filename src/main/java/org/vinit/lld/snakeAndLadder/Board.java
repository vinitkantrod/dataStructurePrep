package org.vinit.lld.snakeAndLadder;

import java.util.HashMap;
import java.util.Map;

public class Board {

    Map<Integer, Integer> snakes;
    Map<Integer, Integer> ladders;
    Map<Player, Integer> playerPosition;
    Dice dice;
    public Board() {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        playerPosition = new HashMap<>();
        dice = new Dice();
    }

    public void addSnake(int x, int y) {
        if (isPositionValid(x) && isPositionValid(y))
            snakes.put(x, y);
    }
    public void addLadder(int x, int y) {
        if (isPositionValid(x) && isPositionValid(y))
            ladders.put(x, y);
    }
    public boolean isSnakeExist(int pos) {
        return snakes.get(pos) != null;
    }
    public boolean isLadderExist(int pos) {
        return ladders.get(pos) != null;
    }

    private boolean isPositionValid(int pos) {
        return pos <= 100 && pos >= 1;
    }

}
