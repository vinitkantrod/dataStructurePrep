package org.vinit.datastructure.leetcode.leetcode75.bitManipulation;

public class Easy_NumberOfOneBits_191 {

    public int hammingWeight(int n) {
        int count;
        for (count = 0; n != 0; ++count)
            n &= (n - 1);
        return count;
    }
}
