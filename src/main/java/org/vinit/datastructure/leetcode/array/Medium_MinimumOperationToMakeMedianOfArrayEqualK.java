package org.vinit.datastructure.leetcode.array;

import java.util.Arrays;

public class Medium_MinimumOperationToMakeMedianOfArrayEqualK {

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        long answer = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                answer += (long) Math.max(0, nums[i] - k);
            } else if (i == n/2) {
                answer += (long) Math.abs(k - nums[i]);
            } else {
                answer += (long) Math.max(k - nums[i], 0);
            }
        }
        return answer;
    }
}
