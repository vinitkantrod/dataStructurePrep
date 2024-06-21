package org.vinit.datastructure.leetcode.leetcode150.arrays;

public class Easy_RemoveElement_27 {

    public static int removeElement(int[] nums, int val) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            if (nums[lo] != val)
                lo++;
            else {
                int t = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = t;
                hi--;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
    }
}
