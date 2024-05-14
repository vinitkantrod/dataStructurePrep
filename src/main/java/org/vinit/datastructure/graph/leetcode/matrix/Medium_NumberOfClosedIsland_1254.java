package org.vinit.datastructure.graph.leetcode.matrix;

public class Medium_NumberOfClosedIsland_1254 {

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j<m; j++) {
                if (grid[i][j] == 1) continue;
                if (i==0 || j == 0 || i == n-1 || j == m-1) {
                    dfs(i, j, grid);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 0) {
                    dfs(i, j, grid);
                    count++;
                }
        return count;
    }

    private void dfs(int i, int j, int[][] grid) {
        if (i < 0 || j<0 || i>=grid.length || j >= grid[0].length || grid[i][j] == 1) return;
        grid[i][j] = 1;
        int[] dirs = new int[]{0,1,0,-1,0};
        for (int k = 0; k< 4; k++) {
            dfs(i + dirs[k], j + dirs[k + 1], grid);
        }
    }
}
