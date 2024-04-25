package org.vinit.datastructure.strings.leetcode;

public class Medium_LongestIdealSubsequenceString_2370 {

    public static int longestIdealString(String s, int k) {
//        StringBuilder sb = new StringBuilder();
//        int lastIndex = -1;
//        for (int i = 0; i < s.length(); i++) {
//            if (lastIndex == -1) lastIndex = i;
//            int currChar = s.charAt(lastIndex);
//            int nextChar = s.charAt(i);
//            if (Math.abs(currChar - nextChar) <= k) {
//                sb.append(s.charAt(i));
//                lastIndex = i;
//            }
//        }
//        return sb.toString().length();

        int N = s.length();
        int[] dp = new int[26];

        int res = 0;
        // Updating dp with the i-th character
        for (int i = 0; i < N; i++) {
            int curr = s.charAt(i) - 'a';
            int best = 0;
            for (int prev = 0; prev < 26; prev++) {
                if (Math.abs(prev - curr) <= k) {
                    best = Math.max(best, dp[prev]);
                }
            }

            // Appending s[i] to the previous longest ideal subsequence allowed
            dp[curr] = Math.max(dp[curr], best + 1);
            res = Math.max(res, dp[curr]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestIdealString("acfgbd", 2));
        System.out.println(longestIdealString("abcd", 3));
        System.out.println(longestIdealString("pvjcci", 4));
    }
}
