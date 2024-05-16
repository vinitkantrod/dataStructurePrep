package org.vinit.datastructure.leetcode.array.twoSumPatterns;

import java.util.Arrays;

public class Medium_MinimiseMaximumPairSumInArray_1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > maxSum) maxSum = nums[left] + nums[right];
            left++;
            right--;
        }
        return maxSum;
    }
}
