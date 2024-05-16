package org.vinit.datastructure.leetcode.array;

import java.util.Arrays;

public class Easy_MinMaxGame_2293 {

    public static int minMaxGame(int[] nums) {
        while (nums.length != 1) {
            int[] num = new int[nums.length / 2];
            for (int i = 0; i < num.length; i++) {
                if (i % 2 == 0) num[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                else num[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
            nums = num;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(minMaxGame(new int[]{1,3,5,2,4,8,2,2}));
    }
}
