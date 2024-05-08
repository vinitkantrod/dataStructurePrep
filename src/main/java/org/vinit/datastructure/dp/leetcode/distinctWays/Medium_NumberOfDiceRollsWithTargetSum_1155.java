package org.vinit.datastructure.dp.leetcode.distinctWays;

import java.util.Arrays;

public class Medium_NumberOfDiceRollsWithTargetSum_1155 {

    int M = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] memo = new int[n + 1][target + 1];
        for (int[] m : memo) Arrays.fill(m, -1);
        return topDown(n, k, target, memo);
    }
    private int topDown(int n, int k, int target, int[][] memo) {
        if (n == 0 && target == 0) return 1;
        if (n != 0 && target == 0) return 0;
        if (n == 0 && target != 0) return 0;
        if (memo[n][target] != -1) return memo[n][target];
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            if (target - i >= 0)
                ans = (ans % M) + (topDown(n - 1, k, target - i, memo) % M);
        }
        memo[n][target] = ans % M;
        return memo[n][target];
    }
}
