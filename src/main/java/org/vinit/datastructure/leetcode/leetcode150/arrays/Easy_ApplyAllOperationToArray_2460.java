package org.vinit.datastructure.leetcode.leetcode150.arrays;

import java.util.Arrays;

public class Easy_ApplyAllOperationToArray_2460 {

    public static int[] applyOperations(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int i = 0, j = 0;
        while (j < N) {
            if (nums[j] != 0) nums[i++] = nums[j];
            j++;
        }
        while (i < N) nums[i++] = 0;
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(applyOperations(new int[]{1,2,2,1,1,0})));
    }
}
