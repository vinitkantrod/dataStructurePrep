package org.vinit.datastructure.leetcode.leetcode75.hashmap;

import java.util.Arrays;

public class Medium_DetermineIfTwoArrayAreClose_1657 {

    public boolean closeStrings(String word1, String word2) {
        int[] word1Arr = new int[26];
        int[] word2Arr = new int[26];
        for (char c : word1.toCharArray()) word1Arr[c - 'a']++;
        for (char c : word2.toCharArray()) word2Arr[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if ((word1Arr[i] == 0 && word2Arr[i] > 0) ||
                    (word1Arr[i] > 0 && word2Arr[i] == 0)) return false;
        }
        Arrays.sort(word1Arr);
        Arrays.sort(word2Arr);
        return Arrays.equals(word1Arr, word2Arr);
    }
}
