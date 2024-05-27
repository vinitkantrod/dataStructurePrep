package org.vinit.datastructure.leetcode.strings;

import java.util.Arrays;

public class Medium_MinimumNumberOfKeypresses_2268 {

    public int minimumKeypresses(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;
        Arrays.sort(freq);
        int min = 0, inc = 1, count = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] > 0) {
                min += freq[i] * inc;
                count += 1;
                if (count == 9) {
                    inc += 1;
                    count = 0;
                }
            }
        }
        return min;
    }
}
