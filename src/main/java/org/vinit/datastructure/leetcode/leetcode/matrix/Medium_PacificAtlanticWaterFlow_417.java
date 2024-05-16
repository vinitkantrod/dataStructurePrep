package org.vinit.datastructure.leetcode.leetcode.matrix;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_PacificAtlanticWaterFlow_417 {

    static int numRows;
    static int numCols;
    static int[][] matrix;
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights.length == 0 && heights[0].length == 0) return new ArrayList<>();

        numRows = heights.length;
        numCols = heights[0].length;
        matrix = heights;

        boolean[][] pacificReachable = new boolean[numRows][numCols];
        boolean[][] atlanticReachable = new boolean[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            dfs(i, 0, pacificReachable);
            dfs(i, numCols - 1, atlanticReachable);
        }
        for (int j = 0; j < numCols; j++) {
            dfs(0, j, pacificReachable);
            dfs(numRows - 1, j, atlanticReachable);
        }

        List<List<Integer>> response = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numCols; j++)
                if (pacificReachable[i][j] && atlanticReachable[i][j])
                    response.add(List.of(i, j));
        return response;
    }

    private static void dfs(int i, int j, boolean[][] reachable) {
        reachable[i][j] = true;
        int[] DIRECTIONS = new int[]{0,1,0,-1,0};
        for (int dir = 0; dir < 4; dir++) {
            int newI = i + DIRECTIONS[dir];
            int newJ = j + DIRECTIONS[dir + 1];
            if (newI < 0 || newJ < 0 || newI >= numRows || newJ >= numCols) continue;
            if (reachable[newI][newJ]) continue;
            if (matrix[newI][newJ] < matrix[i][j]) continue;
            dfs(newI, newJ, reachable);
        }
    }

    public static void main(String[] args) {
        pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
    }
}
