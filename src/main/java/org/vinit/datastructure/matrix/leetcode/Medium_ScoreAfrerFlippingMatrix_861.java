package org.vinit.datastructure.matrix.leetcode;

public class Medium_ScoreAfrerFlippingMatrix_861 {

    public int matrixScore(int[][] grid) {

        // O(m.n) | O(1)
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                // flip rows
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        // optimise column except first column
        for (int j = 1; j < n; j++) {
            int countZero = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 0) countZero++;
            }
            if (countZero > m-countZero) {
                // flip column
                for (int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        // calculate final score
        int score = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int columnScore = grid[i][j] << (n - j - 1);
                score += columnScore;
            }
        }
        return score;
    }
}
