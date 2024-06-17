package org.vinit.datastructure.leetcode.array;

public class Hard_PatchingArray_330 {
    public static int minPatches(int[] nums, int n) {
        int i = 0, patch = 0;
        long miss = 1; // long to avoid integer overflow
        while (miss <= n) {
            System.out.println("While: {i: "+i+", patch: " + patch + ", miss: " + miss + "}");
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
                System.out.println("Miss after adding nums[i]: " + miss);
            } else {
                miss += miss;
                System.out.println("Miss after adding Miss: " + miss);
                patch++;
            }
        }
        return patch;
    }

    public static void main(String[] args) {
        System.out.println(minPatches(new int[]{1,2,3,8}, 80));
    }
}
