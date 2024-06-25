package org.vinit.datastructure.leetcode.leetcode150.hashMap;

public class Easy_ValidAnagram_242 {

    public boolean isAnagram(String s, String t) {
        int[] charArr = new int[26];
        for (char c : s.toCharArray()) charArr[c - 'a']++;
        for (char c : t.toCharArray()) charArr[c - 'a']--;
        for (int i = 0; i < 26; i++) if (charArr[i] != 0) return false;
        return true;
    }
}
