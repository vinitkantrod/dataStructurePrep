package org.vinit.datastructure.leetcode.dp.distinctWays;

import java.util.Arrays;

public class Medium_OutOfBoundaryPath_576 {

    int M = 1_000_000_007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int[][] l : dp) for (int[] s : l) Arrays.fill(s, -1);
        return dfs(m, n, maxMove, startRow, startColumn, dp);
    }
    private int dfs(int m, int n, int N, int i, int j, int[][][] dp) {
        if (i == m || j == n || i < 0 || j < 0) return 1;
        if (N == 0) return 0;
        if (dp[i][j][N] >= 0) return dp[i][j][N];
        dp[i][j][N] = (
                (dfs(m,n,N - 1,i - 1,j, dp) + dfs(m, n, N - 1, i + 1, j, dp)) % M +
                (dfs(m,n,N - 1,i,j - 1, dp) + dfs(m, n, N - 1, i, j + 1, dp)) % M
                ) % M;
        return dp[i][j][N];
    }
}
