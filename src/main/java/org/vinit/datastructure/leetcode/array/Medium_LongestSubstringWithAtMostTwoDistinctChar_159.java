package org.vinit.datastructure.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class Medium_LongestSubstringWithAtMostTwoDistinctChar_159 {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int N = s.length();
        if (N < 3) return N;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLen = 2;
        while (end < s.length()) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            if (map.size() > 2 ) {
                char startChar = s.charAt(start);
                map.put(startChar, map.getOrDefault(startChar, 0) - 1);
                if (map.get(startChar) <= 0) map.remove(startChar);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("aabbccc"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("aaabbb"));
    }
}
