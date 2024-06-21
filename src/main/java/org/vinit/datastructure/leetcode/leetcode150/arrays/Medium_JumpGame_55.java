package org.vinit.datastructure.leetcode.leetcode150.arrays;

public class Medium_JumpGame_55 {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) lastPos = i;
        }
        return lastPos == 0;
    }
}
