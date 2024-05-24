package org.vinit.datastructure.leetcode.backtracking;

public class Hard_MaximumScoreWordsFormedByLetters_1255 {

    int maxScore;
    int[] freq;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int W = words.length;
        maxScore = 0;
        freq = new int[26];
        for (char c : letters) freq[c - 'a']++;
        check(W - 1, words, letters, score, new int[26], 0);
        return maxScore;
    }
    private void check(int w, String[] words, char[] letters, int[] score, int[] subset, int totalScore) {
        if (w == -1) {
            maxScore = Math.max(maxScore, totalScore);
            return;
        }
        // ignore this work
        check(w - 1, words, letters, score, subset, totalScore);
        // consider this word;
        int L = words[w].length();
        for (int i = 0; i < L; i++) {
            int c = words[w].charAt(i) - 'a';
            subset[c]++;
            totalScore += score[c];
        }
        if (isValid(subset))
            check(w - 1, words, letters, score, subset, totalScore);
        //reverse all subset
        for (int i = 0; i < L; i++) {
            int c = words[w].charAt(i) - 'a';
            subset[c]--;
            totalScore -= score[c];
        }
    }
    private boolean isValid(int[] subset) {
        for (int i = 0; i < 26; i++)
            if (freq[i] < subset[i])
                return false;
        return true;
    }
}
