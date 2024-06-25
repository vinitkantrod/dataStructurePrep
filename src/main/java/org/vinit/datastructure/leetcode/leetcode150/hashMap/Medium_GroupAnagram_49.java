package org.vinit.datastructure.leetcode.leetcode150.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Medium_GroupAnagram_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String s : strs) {
            String w = sortedString(s);
            if (!groupMap.containsKey(w)) groupMap.put(w, new ArrayList<>());
            groupMap.get(w).add(s);
        }
        return groupMap.values().stream().toList();
    }
    private String sortedString(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (arr[i] != 0) {
                sb.append( (char) i + 'a');
                arr[i]--;
            }
        }
        return sb.toString();
    }
}
