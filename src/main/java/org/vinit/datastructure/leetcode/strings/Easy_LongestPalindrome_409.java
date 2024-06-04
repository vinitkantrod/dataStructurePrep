package org.vinit.datastructure.leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Easy_LongestPalindrome_409 {

    public int longestPalindrome(String s) {
        Set<Character> charSet = new HashSet<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            if (charSet.contains(c)) {
                charSet.remove(c);
                res += 2;
            } else {
                charSet.add(c);
            }
        }
        if (!charSet.isEmpty()) res++;
        return res;
    }
}
