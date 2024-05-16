package org.vinit.datastructure.leetcode.leetcode75.arrayStrings;

public class Easy_MergeStringAlternatively_1768 {

    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) sb.append(word1.charAt(i));
            if (i < word2.length()) sb.append(word2.charAt(i));
            i++;
        }
        while (i < word1.length()) sb.append(word1.charAt(i++));
        while (i < word2.length()) sb.append(word1.charAt(i++));
        return sb.toString();
    }
}
