package org.vinit.datastructure.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Easy_MostFrequentEvenElement_2404 {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        int lastCount = Integer.MIN_VALUE;
        int lastEle = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int k = e.getKey();
            if (k % 2 == 0 && e.getValue() > lastCount) {
                lastEle = k;
                lastCount = e.getValue();
            }
        }
        return lastEle;
    }
}
