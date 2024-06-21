package org.vinit.datastructure.leetcode.leetcode150.arrays;

public class Easy_ReverseFirstKChar_541 {

    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int start = 0; start < s.length(); start += k * 2) {
            int i = start, j = Math.min(start + k - 1, s.length() - 1);
            while (i < j) {
                char cc = ch[i];
                ch[i++] = ch[j];
                ch[j--] = cc;
            }
        }
        return new String(ch);
    }
}
