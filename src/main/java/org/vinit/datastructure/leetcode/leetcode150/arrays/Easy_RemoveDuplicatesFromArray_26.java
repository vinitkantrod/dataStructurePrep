package org.vinit.datastructure.leetcode.leetcode150.arrays;

import java.util.Arrays;

public class Easy_RemoveDuplicatesFromArray_26 {
    public static int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
            System.out.println(insertIndex + " - " + Arrays.toString(nums));
        }
        return insertIndex;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4,5}));
    }
}
