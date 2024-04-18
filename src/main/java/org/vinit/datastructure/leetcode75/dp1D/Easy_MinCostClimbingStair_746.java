package org.vinit.datastructure.leetcode75.dp1D;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Easy_MinCostClimbingStair_746 {

    public static int minCostClimbingStairs(int[] cost) {
//        int[] dp = new int[cost.length + 1];
//        for (int i = 2; i < cost.length; i++) dp[i] = Math.min(dp[i - 2] + cost[i], dp[i - 1] + cost[i - 1]);
//        return dp[cost.length - 1];

        int dp[] = new int[cost.length + 1];

        // Start iteration from step 2, since the minimum cost of reaching
        // step 0 and step 1 is 0
        for (int i = 2; i < dp.length; i++) {
            int takeOneStep = dp[i - 1] + cost[i - 1];
            int takeTwoSteps = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(takeOneStep, takeTwoSteps);
        }

        // The final element in minimumCost refers to the top floor
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
    }
}
