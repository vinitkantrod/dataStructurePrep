package org.vinit.datastructure.leetcode.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Medium_FindFirstAndLastPosOfEleInArray_34 {

    public static int[] searchRange(int[] nums, int target) {
        int firstOccurance = findBound(nums, target, true);
        if (firstOccurance == -1) return new int[]{-1, -1};
        int secondBound = findBound(nums, target, false);
        return new int[]{firstOccurance, secondBound};
    }
    private static int findBound(int[] nums, int target, boolean isFirst) {
        int n = nums.length;
        int left =0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) /2;
            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == left || nums[mid - 1] != target)
                        return mid;
                    right = mid - 1;
                } else {
                    if (mid == right || nums[mid + 1] != target)
                        return mid;
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{4,5,5,7,8,8,10}, 5)));
    }
}
