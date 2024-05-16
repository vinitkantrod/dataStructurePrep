package org.vinit.datastructure.leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Easy_CountSpecialChar_3120 {

    public int numberOfSpecialChars(String word) {
        char[] ch = word.toCharArray();
        int count = 0;
        Map<Character, Set<Character>> map = new HashMap<>();
        for (char c : ch) {
            Character charValue = Character.toLowerCase(c);
            if (!map.containsKey(charValue)) {
                map.put(charValue, new HashSet<>());
            }
            map.get(charValue).add(c);
        }
        for (Map.Entry<Character, Set<Character>> m : map.entrySet()) {
            if (m.getValue().size() == 2) count++;
        }
        return count;
    }
}
