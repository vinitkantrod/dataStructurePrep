package org.vinit.datastructure.leetcode.dp.distinctWays;

import java.util.Arrays;

public class Medium_TargetSum_494 {

    int total = 0;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        int[][] memo = new int[nums.length][2 * total + 1];
        for (int[] x : memo) Arrays.fill(x, Integer.MIN_VALUE);
        return calculate(nums, 0, 0, target, memo);
    }
    private int calculate(int[] nums, int i, int sum, int target, int[][] memo) {
        if (i == nums.length) {
            if (sum == target) return 1;
            else return 0;
        }
        if (memo[i][sum + total] != Integer.MIN_VALUE) return memo[i][sum + total];
        int add = calculate(nums, i + 1, sum + nums[i], target, memo);
        int sub = calculate(nums, i  + 1, sum - nums[i], target, memo);
        memo[i][sum + total] = add + sub;
        return memo[i][sum + total];
    }
}
