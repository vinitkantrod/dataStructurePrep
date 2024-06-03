package org.vinit.datastructure.leetcode.strings;

public class Medium_AppendCharactersToStringToMakeSubsequence_2486 {
    public int appendCharacters(String s, String t) {
        if (s.isEmpty()) return t.length();
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return t.length() - j;
    }
}
