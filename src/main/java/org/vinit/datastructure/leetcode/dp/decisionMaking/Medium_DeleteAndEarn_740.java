package org.vinit.datastructure.leetcode.dp.decisionMaking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Medium_DeleteAndEarn_740 {

    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int i : nums) {
            freqCount.put(i, freqCount.getOrDefault(i, 0) + i);
            maxNumber = Math.max(maxNumber, i);
        }
        int[] memo = new int[maxNumber + 1];
        memo[1] = freqCount.getOrDefault(1, 0);
        for (int i = 2; i < memo.length; i++) {
            int gain = freqCount.getOrDefault(i, 0);
            memo[i] = Math.max(memo[i - 1], memo[i - 2] + gain);
        }
        return memo[maxNumber];
    }
}
