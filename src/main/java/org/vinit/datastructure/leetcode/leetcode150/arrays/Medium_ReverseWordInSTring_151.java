package org.vinit.datastructure.leetcode.leetcode150.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Medium_ReverseWordInSTring_151 {
    public String reverseWords(String s) {
        List<String> reverse = Arrays.asList(s.trim().replaceAll("\\s+", " ").split(" "));
        Collections.reverse(reverse);
        return String.join(" ", reverse);
    }
}
