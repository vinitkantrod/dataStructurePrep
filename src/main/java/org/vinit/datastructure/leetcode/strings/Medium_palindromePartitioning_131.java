package org.vinit.datastructure.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

public class Medium_palindromePartitioning_131 {

    public List<List<String>> partition(String s) {
        // TC: O(N.2^N) || SC: O(N)
        List<List<String>> result = new ArrayList<>();
        dfs(0, s, new ArrayList<String>(), result);
        return result;
    }
    private void dfs(int start, String s, List<String> currList, List<List<String>> result) {
        if (start >= s.length()) result.add(new ArrayList<>(currList));
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                currList.add(s.substring(start, end + 1));
                dfs(end + 1, s, currList, result);
                currList.remove(currList.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int start , int end) {
        while (start < end)
            if (s.charAt(start++) != s.charAt(end--)) return false;
        return true;
    }
}
