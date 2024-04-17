package org.vinit.datastructure.leetcode75.slidingWindow;

public class Medium_MaximumNumberOfVowelInSubString_1456 {

    public int maxVowels(String s, int k) {
        int i = 0, j = 0;
        int maxVowelCount = 0;
        int currVowelCount = 0;
        int windowCount = 0;
        while (windowCount < k && j < s.length()) {
            if (isCharVowel(s.charAt(j++))) currVowelCount++;
            windowCount++;
        }
        maxVowelCount = Math.max(maxVowelCount, currVowelCount);
        while (j < s.length()) {
            if (isCharVowel(s.charAt(i++))) currVowelCount--;
            if (isCharVowel(s.charAt(j++))) currVowelCount++;
            maxVowelCount = Math.max(maxVowelCount, currVowelCount);
        }
        return maxVowelCount;
    }
    private Boolean isCharVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c== 'u';
    }
}
