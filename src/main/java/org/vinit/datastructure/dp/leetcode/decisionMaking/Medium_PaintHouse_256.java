package org.vinit.datastructure.dp.leetcode.decisionMaking;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Medium_PaintHouse_256 {

    public static int minCost(int[][] costs) {
        int n = costs.length - 1;
        if (costs.length == 0) return 0;
        for(int i = 1; i <= n; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(costs[n][0], Math.min(costs[n][1], costs[n][2]));
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{{17,2,17}, {16,16,5}, {14,3,19}}));
        System.out.println(minCost(new int[][]{{17,2,17}, {16,16,5}}));
        System.out.println(minCost(new int[][]{{1,2,3}, {3,2,1}, {10,0,10}}));
    }
}
