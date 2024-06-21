package org.vinit.datastructure.leetcode.leetcode150.arrays;

public class Easy_MajorityElement_169 {
    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int i : nums) {
            if (count == 0) candidate = i;
            count += (i == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,1,2}));
    }
}
