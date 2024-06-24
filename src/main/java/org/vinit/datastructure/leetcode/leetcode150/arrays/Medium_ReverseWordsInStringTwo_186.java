package org.vinit.datastructure.leetcode.leetcode150.arrays;

public class Medium_ReverseWordsInStringTwo_186 {
    public void reverseWords(char[] s) {
        // find index of
        reverse(s, 0, s.length - 1);
        reverseEachWord(s);

    }
    private void reverse(char[] c, int start, int end) {
        while (start < end) {
            char t = c[start];
            c[start++] = c[end];
            c[end--] = t;
        }
    }
    private void reverseEachWord(char[] s) {
        int n = s.length;
        int start = 0, end = n - 1;
        while (start < n) {
            while (end < n && s[end] != ' ') ++end;
            reverse(s, start, end - 1);
            start = end + 1;
            ++end;
        }
    }
}
