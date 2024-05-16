package org.vinit.datastructure.leetcode.leetcode75.slidingWindow;

public class Medium_LongestSubArrayAfterDeletingOne_1493 {

    public int longestSubarray(int[] nums) {
        int left = 0, right;
        int k = 1;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) k--;
            if (k < 0) k += 1 - nums[left++];
        }
        return right - left - 1;
    }
}
