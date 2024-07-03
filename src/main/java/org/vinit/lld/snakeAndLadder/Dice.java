package org.vinit.lld.snakeAndLadder;

import java.util.Random;

public class Dice {
    private static final Integer MINVALUE = 1;
    private static final Integer MAXVALUE = 6;
    Random random;
    public Dice() {}

    public Integer roll() {
        return random.nextInt((MAXVALUE - MINVALUE)) + 1;
    }
}
