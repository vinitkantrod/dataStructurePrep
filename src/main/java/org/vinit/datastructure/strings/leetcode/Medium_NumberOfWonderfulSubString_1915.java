package org.vinit.datastructure.strings.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Medium_NumberOfWonderfulSubString_1915 {

    static long count = 0;
    public static long wonderfulSubstrings(String word) {
        // Time limit exceeded
//        int N = word.length();
//        for (int k = 0; k < N; k++)
//            combination(word, k, N, "");
//        return count;
        int N = word.length();

        // Create the frequency map
        // Key = bitmask, Value = frequency of bitmask key
        Map<Integer, Integer> freq = new HashMap<>();

        // The empty prefix can be the smaller prefix, which is handled like this
        freq.put(0, 1);

        int mask = 0;
        long res = 0L;
        for (int i = 0; i < N; i++) {
            char c = word.charAt(i);
            int bit = c - 'a';

            // Flip the parity of the c-th bit in the running prefix mask
            mask ^= (1 << bit);

            // Count smaller prefixes that create substrings with no odd occurring letters
            res += freq.getOrDefault(mask, 0);

            // Increment value associated with mask by 1
            freq.put(mask, freq.getOrDefault(mask, 0) + 1);

            // Loop through every possible letter that can appear an odd number of times in a substring
            for (int odd_c=0; odd_c < 10; odd_c++) {
                res += freq.getOrDefault(mask ^ (1 << odd_c),0);
            }
        }
        return res;
    }
    private static void combination(String word, int start, int end, String str) {
        if (start >= end) return;
        str = str + word.charAt(start);
        System.out.println(start + "-Adding: " + str);
        // check for wonderful string
        if (isStringWonderful(str)) count++;
        combination(word, start + 1, end, str);
    }

    private static Boolean isStringWonderful(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);map.put('b', 0);map.put('c', 0);map.put('d', 0);
        map.put('e', 0);map.put('f', 0);map.put('g', 0);map.put('h', 0);
        map.put('i', 0);map.put('j', 0);
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int oddCount = 0;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getValue() % 2 == 1) oddCount++;
        }
        return oddCount <= 1;

    }

    public static void main(String[] args) {
        System.out.println(wonderfulSubstrings("aab"));
    }
}
