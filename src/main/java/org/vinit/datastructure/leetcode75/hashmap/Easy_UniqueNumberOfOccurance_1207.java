package org.vinit.datastructure.leetcode75.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Easy_UniqueNumberOfOccurance_1207 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Integer i : map.values()) {
            if (set.contains(i)) return false;
            set.add(i);
        }
        return true;
    }
}
