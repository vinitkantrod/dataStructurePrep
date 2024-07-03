package org.vinit.lld.snakeAndLadder;

import java.util.Scanner;

public class SnakeAndLadderDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SnakeAndLadderGame game = new SnakeAndLadderGame();
        int numberOfSnake = sc.nextInt();
        while (numberOfSnake > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            game.addSnake(start, end);
            numberOfSnake--;
        }
        int numberOfLadder = sc.nextInt();
        while (numberOfLadder > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            game.addLadder(start, end);
            numberOfLadder--;
        }
        int numberOfPlayer = sc.nextInt();
        while (numberOfPlayer > 0) {
            String player = sc.next();
            game.addPlayer(player);
            numberOfPlayer--;
        }
        game.start();
    }
}
