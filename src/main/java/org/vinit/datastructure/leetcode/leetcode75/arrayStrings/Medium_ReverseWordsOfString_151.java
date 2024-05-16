package org.vinit.datastructure.leetcode.leetcode75.arrayStrings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Medium_ReverseWordsOfString_151 {
    public static String reverseWords(String s) {
        List<String> stringArr = Arrays.asList(s
                    .trim()
                    .replaceAll("\\s+", " ")
                    .split(" ")
        );
        Collections.reverse(stringArr);
        return String.join(" ", stringArr);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world   ok now     this     "));
    }
}
