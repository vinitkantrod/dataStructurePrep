package org.vinit.datastructure.leetcode.array;

public class Medium_SingleNumberThree_260 {
    public int[] singleNumber(int[] nums) {
        // O(n) | O(1)
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) if ((num & diff) != 0) x ^= num;

        return new int[]{x, bitmask^x};
    }
}
