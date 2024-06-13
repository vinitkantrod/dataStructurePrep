package org.vinit.datastructure.leetcode.array;

import java.util.Arrays;

public class Easy_MinNumOfMovesToSeat_2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == students[i]) continue;
            moves += Math.abs(students[i] - seats[i]);
        }
        return moves;
    }
}
