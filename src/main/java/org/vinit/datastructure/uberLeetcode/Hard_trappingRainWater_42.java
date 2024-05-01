package org.vinit.datastructure.uberLeetcode;

public class Hard_trappingRainWater_42 {

    public static int trap(int[] height) {
        int[] leftTrap = new int[height.length];
        int leftMax = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > leftMax) leftMax = height[i];
            else leftTrap[i] = leftMax - height[i];
        }
        int rightMax = 0;
        int sum = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > rightMax) rightMax = height[i];
            int diffHeight = rightMax - height[i];
            leftTrap[i] = Math.min(leftTrap[i], diffHeight);
            sum += leftTrap[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
