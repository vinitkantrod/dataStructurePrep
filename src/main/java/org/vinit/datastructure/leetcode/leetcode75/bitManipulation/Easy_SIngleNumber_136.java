package org.vinit.datastructure.leetcode.leetcode75.bitManipulation;

public class Easy_SIngleNumber_136 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) res = res ^ i;
        return res;
    }
}
