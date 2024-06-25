package org.vinit.datastructure.leetcode.leetcode150.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hard_MinimumWindowSubString_76 {

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c: t.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0, formed = 0;
        int req = charCount.size();
        Map<Character, Integer> windowCount = new HashMap<>();
        int[] ans = {-1, 0, 0};
        while (r < s.length()) {
            char c = s.charAt(r);
            windowCount.put(c, windowCount.getOrDefault(c,0) + 1);
            if (charCount.containsKey(c) && charCount.get(c) == windowCount.get(c)) {
                formed++;
            }
            while (l < r && formed == req) {
                c = s.charAt(l);
                l++;
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowCount.put(c, windowCount.getOrDefault(c, 0) - 1);
                if (charCount.containsKey(c) && charCount.get(c) > windowCount.get(c)) {
                    formed--;
                }
            }
            r++;
        }
        return ans[0] == -1 ? "": s.substring(ans[1], ans[2] + 1);
    }
}
