package org.vinit.datastructure.leetcode.array;

public class Medium_ContainerWithMostWater_11 {

    public static int maxArea(int[] height) {
        int arrWidth = height.length - 1;

        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            int leftMax = height[left];
            int rightMax = height[right];
            System.out.println(left + "- " + right);
            int minHeight = Math.min(leftMax, rightMax);
            maxWater = Math.max(maxWater, minHeight * arrWidth);
            System.out.println(maxWater);
            arrWidth--;
            if (leftMax < rightMax) left++;
            else right--;
        }
        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
