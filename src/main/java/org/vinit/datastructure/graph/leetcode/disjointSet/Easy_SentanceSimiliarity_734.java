package org.vinit.datastructure.graph.leetcode.disjointSet;

import java.util.*;

public class Easy_SentanceSimiliarity_734 {

    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
//        if (sentence1.length != sentence2.length) return false;
//        Map<String, Set<String>> wordsToWordMap = new HashMap<>();
//        for (List<String> pair : similarPairs) {
//            wordsToWordMap.computeIfAbsent(pair.get(0), value -> new HashSet<>()).add(pair.get(1));
//            wordsToWordMap.computeIfAbsent(pair.get(1), value -> new HashSet<>()).add(pair.get(0));
//        }
//        for (int i = 0; i < similarPairs.size(); i++) {
//            if (sentence1[i].equals(sentence2[i])) continue;
//            if (wordsToWordMap.containsKey(sentence1[i]) &&
//            wordsToWordMap.get(sentence1[i]).equals(sentence2[i])) continue;
//            return false;
//        }
//        return true;
//
        if (sentence1.length != sentence2.length) {
            return false;
        }
        Map<String, Set<String>> wordToSimilarWords = new HashMap<>();
        for (List<String> pair : similarPairs) {
            wordToSimilarWords.computeIfAbsent(pair.get(0), value->new HashSet<String>())
                    .add(pair.get(1));
            wordToSimilarWords.computeIfAbsent(pair.get(1), value->new HashSet<String>())
                    .add(pair.get(0));
        }

        for (int i = 0; i < sentence1.length; i++) {
            // If the words are equal, continue.
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }
            // If the words form a similar pair, continue.
            if (wordToSimilarWords.containsKey(sentence1[i]) &&
                    wordToSimilarWords.get(sentence1[i]).contains(sentence2[i])) {
                continue;
            }
            return false;
        }

        return true;
    }
}
