package org.vinit.datastructure.matrix.leetcode;

public class Easy_IslandPerimeter_463 {

    static int perimeterCount = 0;
    public static int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                }
            }
        }
        return perimeterCount;
    }
    private static int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) return 0;
        if (grid[i][j] == 0) return 0;
        if (grid[i][j] == -1) return -1;
        grid[i][j] = -1;
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for (int[] dir : dirs) {
            int retVal = dfs(i + dir[0], j + dir[1], grid);
            if (retVal == 0) perimeterCount++;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }
}
