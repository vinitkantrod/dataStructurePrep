package org.vinit.datastructure.leetcode.strings;

public class Medium_GetEqualSubStringWithinBudget_1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int N = s.length(), maxLen = 0, start = 0, currCost = 0;
        for (int i = 0; i < N; i++) {
            currCost += Math.abs(s.charAt(i) - t.charAt(i));
            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }
}
