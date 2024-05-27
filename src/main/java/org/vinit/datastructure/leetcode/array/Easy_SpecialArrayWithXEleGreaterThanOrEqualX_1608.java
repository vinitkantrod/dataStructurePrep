package org.vinit.datastructure.leetcode.array;

import java.util.Arrays;

public class Easy_SpecialArrayWithXEleGreaterThanOrEqualX_1608 {

    public static int specialArray(int[] nums) {
//        Arrays.sort(nums);
//        int n = nums.length;
//        int specialNum = -1;
//        System.out.println(Arrays.toString(nums));
//        for (int i = 0; i < nums[nums.length - 1]; i++) {
//            int remainingNums = n - i;
//            System.out.println(i + " - " + remainingNums);
//            if (remainingNums == 0 || remainingNums == i - 1) specialNum = i;
//            System.out.println("SN: " + specialNum);
//        }
//        return specialNum;

        Arrays.sort(nums);
        int n = nums.length;

        if (nums[0] >= n) return n;

        for (int i = 1; i <= n; i++) {
            if (nums[n - i] >= i && (n - i - 1 < 0 || nums[n - i - 1] < i)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{3,5}));
        System.out.println(specialArray(new int[]{0,0}));
        System.out.println(specialArray(new int[]{0,4,3,0,4}));
    }
}
