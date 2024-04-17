package org.vinit.datastructure.leetcode75.prefixSum;

public class Easy_PivotIndex_726 {
    public static int pivotIndex(int[] nums) {
        int leftSum = 0, sum = 0;
        for (int i : nums) sum += i;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[]{-1,-1,0,1,1,0}));
    }
}
