package org.vinit.datastructure.leetcode.matrix;

public class Easy_DetermineIfMatrixCanBeObtainedByRotation_1886 {

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int c0 = 0, c90 = 0, c180 = 0, c270 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (target[i][j] == mat[i][j])
                    c0++;
                if (target[i][j] == mat[n - j - 1][i])
                    c90++;
                if (target[i][j] == mat[n - i - 1][n - j  -1])
                    c180++;
                if (target[i][j] == mat[j][n - i - 1])
                    c270++;
            }
        }
        return c0 == n * n || c90 == n * n || c180 == n * n || c270 == n * n;
    }

    private boolean isMatrixEqual(int[][] a, int[][] b) {
        for (int r = 0, rowLen = a.length; r < rowLen; r++) {
            for (int c = 0, colLen = a[0].length; c < colLen; c++) {
                if (a[r][c] != b[r][c]) return false;
            }
        }
        return true;
    }

}
