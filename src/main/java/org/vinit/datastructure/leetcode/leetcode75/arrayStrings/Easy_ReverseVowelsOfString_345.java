package org.vinit.datastructure.leetcode.leetcode75.arrayStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Easy_ReverseVowelsOfString_345 {

    public static String reverseVowels(String s) {
        int i = 0;
        char[] ch = s.toCharArray();
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A','E','I','O','U'));
        int j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !vowelSet.contains(s.charAt(i))) i++;
            while (j >= 0 && !vowelSet.contains(s.charAt(j))) j--;
            System.out.println(i + "- " + j);
            if (i < j) {
                ch[i] = s.charAt(j);
                ch[j] = s.charAt(i);
                i++;
                j--;
            }
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
}
