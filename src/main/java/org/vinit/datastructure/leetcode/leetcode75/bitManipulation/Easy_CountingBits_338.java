package org.vinit.datastructure.leetcode.leetcode75.bitManipulation;

public class Easy_CountingBits_338 {
    public int[] countBits(int n) {
        int[] r = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            r[i] = r[i & (i - 1)] + 1;
        }
        return r;
    }
}
