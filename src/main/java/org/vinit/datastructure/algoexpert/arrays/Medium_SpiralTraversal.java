package org.vinit.datastructure.algoexpert.arrays;

import java.util.ArrayList;
import java.util.List;

public class Medium_SpiralTraversal {
    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        int rowLength = array.length;
        int colLength = array[0].length;
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = array.length - 1;
        int colEnd = array[0].length - 1;
        for (int i = 0; i < (((rowLength * colLength) / 2) / 4) + 1; i++) {
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int col = colStart; col <= colEnd; col++) {
                result.add(array[rowStart][col]);
            }
            rowStart++;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int row = rowStart; row <= rowEnd; row++) {
                result.add(array[row][colEnd]);
            }
            colEnd--;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int col = colEnd; col >= colStart; col--) {
                result.add(array[rowEnd][col]);
            }
            rowEnd--;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int row = rowEnd; row >= rowStart; row--) {
                result.add(array[row][colStart]);
            }
            colStart++;
        }

        return result;
    }
}
