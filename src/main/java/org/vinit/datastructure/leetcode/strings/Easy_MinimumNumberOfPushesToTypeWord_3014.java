package org.vinit.datastructure.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class Easy_MinimumNumberOfPushesToTypeWord_3014 {

    public int minimumPushes(String word) {
        Map<Character, Integer> keyPos = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (keyPos.containsKey(ch)) continue;
            int val = keyPos.size() / 8 + 1;
            keyPos.put(ch, val);
        }
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            res += keyPos.get(word.charAt(i));
        }
        return res;

//        int[] counts = new int[26];
//        int ret = 0;
//        for(char c: word.toCharArray())
//            counts[c - 'a']++;
//        Arrays.sort(counts);
//        for(int i = counts.length -1, j = 0; i > -1; i--, j++)
//            if(counts[i] != 0)
//                ret += counts[i] * (j/8 + 1);
//        return ret;
    }
}
