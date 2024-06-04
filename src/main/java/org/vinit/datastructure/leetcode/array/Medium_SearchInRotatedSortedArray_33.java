package org.vinit.datastructure.leetcode.array;

public class Medium_SearchInRotatedSortedArray_33 {

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        // find pivot
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[n - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("L: " + left + ", R: " + right);
        int ans = binarySearch(nums, 0, left - 1, target);
        if (ans != -1) return ans;
        return binarySearch(nums, left, n - 1, target);
    }
    private static int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) return mid;
            if (target < nums[mid] ) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,8,9,0,1,2,3}, 10));
    }
}
