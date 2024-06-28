package org.vinit.datastructure.leetcode.graph;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class Medium_MaximumTotalImportanceOfRoad_2285 {

    public static long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];
        for (int[] e : roads) {
            degree[e[0]]++;
            degree[e[1]]++;
        }

        Arrays.sort(degree);
        long value = 1;
        long totalImportance = 0;
        for (long d : degree) {
            totalImportance += (value * d);
            value++;
        }
        return totalImportance;
    }

    public static void main(String[] args) {
        System.out.println(maximumImportance(5, new int[][]{{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));
    }
}
