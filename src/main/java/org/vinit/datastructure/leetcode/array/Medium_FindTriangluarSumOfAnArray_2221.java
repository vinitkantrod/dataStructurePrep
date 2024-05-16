package org.vinit.datastructure.leetcode.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Medium_FindTriangluarSumOfAnArray_2221 {

    public static int triangularSum(int[] nums) {
        if (nums.length == 1) return nums[0];
        while (nums.length != 1) {
            int[] num = new int[nums.length - 1];
            for (int i = 0; i < num.length; i++) {
                num[i] = (nums[i] + nums[i + 1]) % 10;
            }
            nums = num;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(triangularSum(new int[]{1,2,3,4,5,6,7}));
    }
}
