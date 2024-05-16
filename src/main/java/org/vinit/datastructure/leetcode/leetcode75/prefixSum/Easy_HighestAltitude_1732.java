package org.vinit.datastructure.leetcode.leetcode75.prefixSum;

public class Easy_HighestAltitude_1732 {

    public int largestAltitude(int[] gain) {
        int maxGain = 0;
        int currGain = 0;
        for (int i = 0; i < gain.length; i++) {
            currGain = i == 0 ? gain[i] : currGain + gain[i];
            System.out.println(currGain);
            maxGain = Math.max(maxGain, currGain);
        }
        return maxGain;
    }
}
