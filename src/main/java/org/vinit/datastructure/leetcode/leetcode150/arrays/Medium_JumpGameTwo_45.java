package org.vinit.datastructure.leetcode.leetcode150.arrays;

public class Medium_JumpGameTwo_45 {
    public static int jump(int[] nums) {
        int jumps = 0, currEnd = 0, currFarthest = 0;
        for(int i = 0; i < nums.length - 1; i ++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if(i == currEnd) {
                currEnd = currFarthest;
                jumps++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
}
