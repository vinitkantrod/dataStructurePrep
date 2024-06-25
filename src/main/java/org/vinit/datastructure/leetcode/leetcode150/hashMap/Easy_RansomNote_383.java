package org.vinit.datastructure.leetcode.leetcode150.hashMap;

import java.util.HashMap;
import java.util.Map;

public class Easy_RansomNote_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mMap = new HashMap<>();
        for (char c : magazine.toCharArray()) mMap.put(c, mMap.getOrDefault(c, 0) + 1);
        for (char c: ransomNote.toCharArray()) {
            if (!mMap.containsKey(c)) return false;
            mMap.put(c, mMap.get(c) - 1);
            if (mMap.get(c) < 0) return false;
        }
        return true;
    }
}
