package org.vinit.datastructure.leetcode.matrix;

public class Medium_NumberOfIsland_200 {
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) return;
        if (grid[i][j] == '0' || grid[i][j] == '2') return;
        System.out.println("i: " + i + ", j: " + j);
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        grid[i][j] = '2';
        for (int[] direction : directions) {
            dfs(grid, i + direction[0], j + direction[1]);
        }
    }

    public static void main(String[] args) {
        char[][] g = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(g));
    }
}
