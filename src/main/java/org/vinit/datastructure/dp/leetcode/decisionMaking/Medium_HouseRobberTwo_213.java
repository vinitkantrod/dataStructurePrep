package org.vinit.datastructure.dp.leetcode.decisionMaking;

public class Medium_HouseRobberTwo_213 {

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }
    private static int robRange(int[] nums, int l, int r) {
        int a = 0, b = nums[l];
        for (int i = l + 1; i <= r; ++i) {
            int c = Math.max(nums[i] + a, b);
            a = b;
            b = c;
        }
        return b;
    }
    public static void main(String[] args) {
        System.out.println(rob(new int[]{3,2,3,10}));
    }
}
