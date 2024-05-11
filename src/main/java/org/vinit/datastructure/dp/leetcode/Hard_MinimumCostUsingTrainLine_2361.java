package org.vinit.datastructure.dp.leetcode;

public class Hard_MinimumCostUsingTrainLine_2361 {

    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        long[][] memo = new long[regular.length + 1][2];
        int N = regular.length;
        long[] result = new long[N];

        // 1 for regular, 0 for express
        memo[0][1] = 0;  // Regular cost for regular Lane
        memo[0][0] = expressCost;   // Express Cost for Express Lane

        for (int i = 1; i <= N; i++) {
            memo[i][1] = regular[i - 1] + Math.min(memo[i - 1][1], memo[i - 1][0]);
            memo[i][0] = express[i - 1] + Math.min(expressCost + memo[i - 1][1], memo[i - 1][0]);
            result[i - 1] = Math.min(memo[i][0], memo[i][1]);
        }

        return result;
    }
}
