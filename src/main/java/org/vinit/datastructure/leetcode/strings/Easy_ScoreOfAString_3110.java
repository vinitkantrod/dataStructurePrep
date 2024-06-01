package org.vinit.datastructure.leetcode.strings;

public class Easy_ScoreOfAString_3110 {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i = 1; i < s.length(); i++)
            sum += Math.abs((s.charAt(i - 1) - 'a') - (s.charAt(i) - 'a'));
        return sum;
    }
}
