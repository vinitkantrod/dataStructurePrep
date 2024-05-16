package org.vinit.datastructure.leetcode.dp;

public class Hard_MaximalRectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        // O(N*(N*M)) = TC: O(N^2*M)
        // SC O(N*M)
        if (matrix.length == 0) return 0;
        int maxArea = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j > 0 ? dp[i][j - 1] + 1 : 1;
                    int width = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        maxArea = Math.max(maxArea, width * (i - k + 1));
                    }
                }
            }
        }
        return maxArea;
    }
}
