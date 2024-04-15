package org.vinit.datastructure.strings.leetcode;

public class Medium_LongestPalindromicSubString_5 {

    public String longestPalindrome(String s) {

        int[] res = new int[2];
        for (int i = 0; i < s.length(); i++) {
            int oddLen = expand(i, i, s);
            if (oddLen > res[1] - res[0] + 1) {
                int dist = oddLen / 2;
                res[0] = i - dist;
                res[1] = i + dist;
            }
            int evenLength = expand(i, i + 1, s);
            if (evenLength > res[1] - res[0] + 1) {
                int dist = evenLength / 2 - 1;
                res[0] = i - dist;
                res[1] = i + 1 + dist;
            }
        }
        int i = res[0];
        int j = res[1];
        return s.substring(i, j + 1);
    }
    private int expand(int i, int j, String s) {
        int left = i;
        int right = j;
        while (i >= 0 && j < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
