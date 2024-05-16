package org.vinit.datastructure.leetcode.leetcode75.slidingWindow;

public class Easy_MaximumAverageSubArray_643 {

    public double findMaxAverage(int[] nums, int k) {
        // Sliding Window
        int i = 0;
        int j = 0;
        int windowCount = 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        while (j < nums.length && windowCount < k) {
            currSum += nums[j++];
            windowCount++;
        }
        maxSum = Math.max(maxSum, currSum);
        while (j < nums.length) {
            currSum -= nums[i++];
            currSum += nums[j++];
            maxSum = Math.max(maxSum, currSum);
        }
        return (double) maxSum / k;
    }
}
