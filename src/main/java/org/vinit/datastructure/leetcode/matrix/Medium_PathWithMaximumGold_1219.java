package org.vinit.datastructure.leetcode.matrix;

public class Medium_PathWithMaximumGold_1219 {

    int[] DIRECTIONS = new int[]{0,1,0,-1,0};
    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxGold = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxGold = Math.max(maxGold, dfsBacktrack(grid, rows, cols, i, j));
            }
        }
        return maxGold;
    }
    private int dfsBacktrack(int[][] grid, int rows, int cols, int i , int j) {
        if (i<0 || j<0 || i==rows || j==cols || grid[i][j]==0) return 0;
        int maxGold = 0;
        int originalGold = grid[i][j];
        grid[i][j] = 0;
        for (int direction = 0; direction < 4; direction++) {
            maxGold = Math.max(maxGold, dfsBacktrack(grid, rows, cols, DIRECTIONS[direction] + i,
                     DIRECTIONS[direction + 1] + j));
        }
        grid[i][j] = originalGold;
        return maxGold + originalGold;
    }
}
