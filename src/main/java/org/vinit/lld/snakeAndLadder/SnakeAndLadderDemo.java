package org.vinit.lld.snakeAndLadder;

import java.util.Scanner;

public class SnakeAndLadderDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SnakeAndLadderGame game = new SnakeAndLadderGame();
        int numberOfSnake = sc.nextInt();
        while (numberOfSnake > 0) {
            String[] position = sc.nextLine().split(" ");
            game.addSnake(Integer.parseInt(position[0]), Integer.parseInt(position[1]));
            numberOfSnake--;
        }
        int numberOfLadder = sc.nextInt();
        while (numberOfLadder > 0) {
            String[] position = sc.nextLine().split(" ");
            game.addLadder(Integer.parseInt(position[0]), Integer.parseInt(position[1]));
            numberOfLadder--;
        }
        int numberOfPlayer = sc.nextInt();
        while (numberOfPlayer > 0) {
            String player = sc.nextLine();
            game.addPlayer(player);
            numberOfPlayer--;
        }
        game.start();
    }
}
