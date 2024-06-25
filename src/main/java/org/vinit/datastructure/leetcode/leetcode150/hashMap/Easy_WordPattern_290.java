package org.vinit.datastructure.leetcode.leetcode150.hashMap;

import java.util.HashMap;
import java.util.Map;

public class Easy_WordPattern_290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> strMap = new HashMap<>();
        String[] strArr = s.trim().split(" ");
        if (strArr.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = strArr[i];
            if (!charMap.containsKey(c)) {
                if (strMap.containsKey(w)) return false;
                else {
                    strMap.put(w, c);
                    charMap.put(c, w);
                }
            } else {
                if (!charMap.get(c).equals(w)) return false;
            }
        }
        return true;
    }
}
