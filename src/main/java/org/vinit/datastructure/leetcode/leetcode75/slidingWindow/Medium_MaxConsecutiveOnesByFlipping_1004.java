package org.vinit.datastructure.leetcode.leetcode75.slidingWindow;

public class Medium_MaxConsecutiveOnesByFlipping_1004 {
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) k--;
            if (k < 0) k += 1 - nums[left++];
        }
        return right - left;
    }

    public static void main(String[] args) {
//        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

}
