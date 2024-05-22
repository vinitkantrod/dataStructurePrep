package org.vinit.datastructure.leetcode.matrix;

import java.util.HashSet;
import java.util.Set;

public class Medium_NumberOfSpacesCleaningRobotCleaned_2061 {

    private static final int[] DIRECTIONS = { 0, 1, 0, -1, 0 };

    public static int numberOfCleanRooms(int[][] room) {
        int nRows = room.length;
        int nCols = room[0].length;
        Set<String> visited = new HashSet<>();
        Set<String> cleaned = new HashSet<>();

        return clean(0, 0, 0, room, visited, cleaned, nRows, nCols);
    }

    private static int clean(int row, int col, int direction, int[][] room, Set<String> visited, Set<String> cleaned,
                      int nRows, int nCols) {
        String visitKey = row + "," + col + "," + direction;
        if (visited.contains(visitKey)) {
            return cleaned.size();
        }

        visited.add(visitKey);
        cleaned.add(row + "," + col);

        int nextRow = row + DIRECTIONS[direction];
        int nextCol = col + DIRECTIONS[direction + 1];
        if (inBound(nextRow, nextCol, nRows, nCols) && room[nextRow][nextCol] == 0) {
            return clean(nextRow, nextCol, direction, room, visited, cleaned, nRows, nCols);
        }

        // Otherwise turn right and clean the current space
        return clean(row, col, (direction + 1) % 4, room, visited, cleaned, nRows, nCols);
    }

    private static boolean inBound(int row, int col, int nRows, int nCols) {
        return 0 <= row && row < nRows && 0 <= col && col < nCols;
    }

    public static void main(String[] args) {
        System.out.println(numberOfCleanRooms(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
    }
}
