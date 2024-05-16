package org.vinit.datastructure.leetcode;

public class Medium_MinimumNumberOfOperationToMakeArrayXOREqualK_2997 {
    public int minOperations(int[] nums, int k) {
        int finalXor = 0;
        for (int n : nums) {
            finalXor = finalXor ^ n;
        }

        return Integer.bitCount(finalXor ^ k);
    }
}
