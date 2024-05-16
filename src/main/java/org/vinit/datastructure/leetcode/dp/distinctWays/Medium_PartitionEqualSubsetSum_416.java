package org.vinit.datastructure.leetcode.dp.distinctWays;

public class Medium_PartitionEqualSubsetSum_416 {

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i : nums) totalSum += i;
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int N = nums.length;
        boolean[][] dp = new boolean[N + 1][subSetSum + 1];
        dp[0][0] = true;
        for (int i = 1; i < N + 1; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= subSetSum; j++) {
                if (j < curr) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - curr];
                }
            }
        }
        return dp[N][subSetSum];
    }
}
