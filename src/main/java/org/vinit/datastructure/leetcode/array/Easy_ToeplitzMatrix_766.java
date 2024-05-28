package org.vinit.datastructure.leetcode.array;

public class Easy_ToeplitzMatrix_766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int j = 0;
            if (!isDiagonalSame(i, j, m ,n ,matrix, matrix[i][j])) return false;
        }
        for (int j = 0; j < n; j++) {
            int i = 0;
            if (!isDiagonalSame(i, j, m ,n ,matrix, matrix[i][j])) return false;
        }
        return true;
    }
    private boolean isDiagonalSame(int i, int j, int m, int n, int[][] matrix, int val) {
        while (i < m && j < n) {
            if (matrix[i][j] != val) return false;
            i++;
            j++;
        }
        return true;
    }
}
