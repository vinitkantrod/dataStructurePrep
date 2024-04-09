package org.vinit.datastructure.dp.leetcode.decisionMaking;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Medium_MaximumProfitFromTradingStock_2291 {

    public static int maximumProfit(int[] present, int[] future, int budget) {
        Integer[][] memo = new Integer[present.length][budget + 1];
        // Reccursive call
        return dp(0, budget, memo, present, future);
    }
    public static int solve(int[] present, int[] future, int start, int budget, Integer[][] memo) {
        if(budget < 0 || start >= present.length) {
            return 0;
        }
        if(memo[start][budget] != null) {
            return memo[start][budget];
        }
        int trade = 0, skipTrade = 0;
        if(present[start] < future[start] && present[start] <= budget) {
            trade = solve(present, future, start + 1, budget - present[start], memo) + (future[start] - present[start]);
        }
        skipTrade = solve(present, future, start + 1, budget, memo);
        return memo[start][budget] = Math.max(trade, skipTrade);
    }
    public static int dp(int idx, int remaining, Integer[][] memo, int[] present, int[] future) {
        if (remaining < 0 || idx >= present.length) return 0;
        System.out.println(idx + "_" + remaining);
        if (memo[idx][remaining] != null) return memo[idx][remaining];
        int trade = 0, skipTrade = 0;
        if (present[idx] < future[idx] && present[idx] <= remaining) {
            trade = dp(idx + 1, remaining - present[idx], memo, present, future)
                    + future[idx] - present[idx];
        }
        skipTrade = dp(idx + 1, remaining, memo, present, future);
        memo[idx][remaining] = Math.max(trade, skipTrade);
        System.out.println("Memo["+idx+"]["+remaining+"]: " + memo[idx][remaining]);
        return memo[idx][remaining];
    }
    public static void main(String[] args) {
        System.out.println(maximumProfit(new int[]{5,4,6,2,3},
                new int[]{8,5,4,3,5}, 10));
    }
}
