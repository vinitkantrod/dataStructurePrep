package org.vinit.datastructure.algoexpert.arrays;

public class Easy_TransposeMatrix {

    public int[][] transposeMatrix(int[][] matrix) {
        // Write your code here.
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                transpose[col][row] = matrix[row][col];
            }
        }
        return transpose;
    }

}
