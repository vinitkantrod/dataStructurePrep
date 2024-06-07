package org.vinit.datastructure.leetcode.strings;

import java.util.*;

public class Medium_ReplaceWords_648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        for (String s : dictionary) set.add(s);
        String[] sentenceWords = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String s : sentenceWords) {
            int low = 0;
            boolean isRoot = false;
            while (low <= s.length() - 1) {
                String sub = s.substring(0, low);
                if (set.contains(sub)) {
                    sb.append(sub);
                    isRoot = true;
                    break;
                }
                low++;
            }
            if (!isRoot) sb.append(s);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
