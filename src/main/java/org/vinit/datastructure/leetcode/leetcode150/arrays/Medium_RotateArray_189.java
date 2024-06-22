package org.vinit.datastructure.leetcode.leetcode150.arrays;

public class Medium_RotateArray_189 {
    public void rotate(int[] nums, int k) {
        // reverse Arr
        // TC: O(n) | SC: O(1)
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
