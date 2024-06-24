package org.vinit.datastructure.leetcode.leetcode150.twoPointers;

public class Medium_ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int arrLen = height.length - 1;
        int left = 0, right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int minHeight = Math.min(leftHeight, rightHeight);
            maxWater = Math.max(maxWater, minHeight * arrLen);
            arrLen--;
            if (leftHeight < rightHeight) left++;
            else right--;
        }
        return maxWater;
    }
}
