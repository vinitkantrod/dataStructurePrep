package org.vinit.datastructure.leetcode.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Medium_TakeKOfEachCharFromLeftOrRight_2516 {
    public static int takeCharacters(String s, int k) {
        int[] arr = new int[3];
        char[] c = s.toCharArray();
        int curr, len = c.length;
        for (curr = 0; curr < len; curr++) {
            arr[c[curr] - 'a']++;
            if (arr[0] >= k && arr[1] >= k && arr[2] >= k) break;
        }
        if (curr == len) return -1;
        int count = curr + 1, min = count,end = len - 1;
        System.out.println(count + " - " + min + " - " + end);
        while (curr >= 0) {
            if (arr[c[curr] - 'a'] == k) {
                while (c[curr] != c[end]) {
                    arr[c[end] - 'a']++;
                    end--;
                    count++;
                }
                end--;
            } else {
                arr[c[curr] - 'a']--;
                count--;
                min = Math.min(count, min);
            }
            curr--;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(takeCharacters("aabaaaacaabc", 2));
    }
}
