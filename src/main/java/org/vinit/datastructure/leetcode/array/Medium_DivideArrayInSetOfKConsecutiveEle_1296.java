package org.vinit.datastructure.leetcode.array;

import java.util.*;

public class Medium_DivideArrayInSetOfKConsecutiveEle_1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (!map.isEmpty()) {
            int first = Collections.min(map.keySet());
            for (int i = first; i < first + k; i++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }
        return true;

    }
}
