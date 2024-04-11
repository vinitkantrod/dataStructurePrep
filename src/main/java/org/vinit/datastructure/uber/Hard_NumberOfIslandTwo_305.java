package org.vinit.datastructure.uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Union Find Ref: https://leetcode.com/problems/number-of-islands-ii/solutions/75470/easiest-java-solution-with-explanations/
 */
public class Hard_NumberOfIslandTwo_305 {

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        int islandCount = 0;
        List<Integer> result = new ArrayList<>();
        int[][][] matrix = new int[m][n][1];
        int pos = 0;
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            dfs(matrix, x, y, islandCount);
            islandCount = matrix[x][y][0];
            result.add(matrix[x][y][0]);
        }
        return result;
    }

    private static void dfs(int[][][] matrix, int x, int y, int islandCount) {
        int minVal = Integer.MAX_VALUE;
        if (x > 0 && matrix[x - 1][y][0] > 0) minVal = Math.min(minVal, matrix[x - 1][y][0]);
        if (y > 0 && matrix[x][y - 1][0] > 0) minVal = Math.min(minVal, matrix[x][y - 1][0]);
        if (x < matrix.length - 1 && matrix[x + 1][y][0] > 0) minVal = Math.min(minVal, matrix[x + 1][y][0]);
        if (y < matrix[0].length - 1 && matrix[x][y + 1][0] > 0) minVal = Math.min(minVal, matrix[x][y + 1][0]);
        if (minVal == Integer.MAX_VALUE) matrix[x][y][0] = islandCount + 1;
        else matrix[x][y][0] = minVal;
        System.out.println(minVal);
        for (int[][] m : matrix) for (int[] mm : m) System.out.println(Arrays.toString(mm));
        System.out.println("============");
    }

    public static void main(String[] args) {
//        System.out.println(numIslands2(3,3, new int[][]{{0,0},{0,1},{1,2},{2,1}}));
//        System.out.println(numIslands2(1,1, new int[][]{{0,0}}));
//        System.out.println(numIslands2(3,3, new int[][]{{0,0},{0,1},{1,1},{2,1},{2,2}}));
//        System.out.println(numIslands2(1,2, new int[][]{{0,1},{0,0}}));
//        System.out.println(numIslands2(2,2, new int[][]{{0,0},{1,1},{0,1}}));
        System.out.println(numIslands2(3,3, new int[][]{{0,1},{1,2},{2,1},{1,0},{0,2},{0,0},{1,1}}));
    }
}
