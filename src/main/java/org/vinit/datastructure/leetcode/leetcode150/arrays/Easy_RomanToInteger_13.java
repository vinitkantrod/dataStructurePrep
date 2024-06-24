package org.vinit.datastructure.leetcode.leetcode150.arrays;

import java.util.Map;

public class Easy_RomanToInteger_13 {

    public static int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50,
                'C', 100,'D', 500,'M', 1000);
        int l = 0;
        int ans = 0;
        while (l < s.length()) {
            if (l == 0 || map.get(s.charAt(l)) <= map.get(s.charAt(l - 1)) ) {
                ans += map.get(s.charAt(l));
            } else {
                ans -= map.get(s.charAt(l - 1));
                ans += (map.get(s.charAt(l)) - map.get(s.charAt(l - 1)));
            }
            l++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCI"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
