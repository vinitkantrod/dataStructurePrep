package org.vinit.datastructure.matrix.leetcode;

public class Easy_LargestLocalValuesInMatrix_2373 {

    public int[][] largestLocal(int[][] grid) {
        int[][] res = new int[grid.length - 2][grid[0].length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                res[i][j] = getLocalMaximum(i + 1, j + 1, grid);

            }
        }
        return res;
    }
    private int getLocalMaximum(int i, int j, int[][] grid) {
        return Math.max(grid[i - 1][j - 1],
                Math.max(grid[i - 1][j],
                Math.max(grid[i - 1][j + 1],
                Math.max(grid[i][j - 1],
                Math.max(grid[i][j],
                Math.max(grid[i][j + 1],
                Math.max(grid[i + 1][j - 1],
                Math.max(grid[i + 1][j], grid[i + 1][j + 1])
                )))))));
    }
}
