package org.vinit.datastructure.leetcode.leetcode150.arrays;

public class Medium_RemoveDuplicatedFromSortedArrayTwo_80 {
    public static int removeDuplicates(int[] nums) {
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                count = 1;
            } else  {
                count++;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
