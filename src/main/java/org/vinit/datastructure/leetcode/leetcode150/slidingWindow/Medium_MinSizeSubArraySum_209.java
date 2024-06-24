package org.vinit.datastructure.leetcode.leetcode150.slidingWindow;

import java.util.List;

public class Medium_MinSizeSubArraySum_209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = 0;
        int left = 0, right = 0;
        int currSum = 0;
        while (right < nums.length) {
            currSum += nums[right];
            while (currSum >= target) {
                minLen = right - left + 1;
                currSum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
