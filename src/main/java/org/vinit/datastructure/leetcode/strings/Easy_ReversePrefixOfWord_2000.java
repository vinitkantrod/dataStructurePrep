package org.vinit.datastructure.leetcode.strings;

public class Easy_ReversePrefixOfWord_2000 {

    public String reversePrefix(String word, char ch) {
        int prefixIndex = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                prefixIndex = i;
                break;
            }
        }
        if (prefixIndex == -1) return word;
        String subString = word.substring(0, prefixIndex + 1);
        String reverseString = new StringBuilder(subString).reverse().toString();
        return reverseString + word.substring(prefixIndex + 1);
    }
}
