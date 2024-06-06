package org.vinit.datastructure.leetcode.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Medium_HandsOfStraight_846 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (!map.isEmpty()) {
            int first = Collections.min(map.keySet());
            for (int i = first; i < first + groupSize; i++) {
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
