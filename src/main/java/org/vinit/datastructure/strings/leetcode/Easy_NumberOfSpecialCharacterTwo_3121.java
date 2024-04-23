package org.vinit.datastructure.strings.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Easy_NumberOfSpecialCharacterTwo_3121 {

    public int numberOfSpecialChars(String word) {
        Map<Character, Integer> firstUpperCasePos = new HashMap<>();
        Map<Character, Integer> lastLowerCasePos = new HashMap<>();

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)) {
                lastLowerCasePos.put(ch, i);
            } else if(Character.isUpperCase(ch)) {
                char lowerCh = Character.toLowerCase(ch);
                if(!firstUpperCasePos.containsKey(lowerCh)) {
                    firstUpperCasePos.put(lowerCh, i);
                }
            }
        }
        int specialCharsCount = 0;
        for(char ch: lastLowerCasePos.keySet()) {
            if(firstUpperCasePos.containsKey(ch)) {
                if(lastLowerCasePos.get(ch) < firstUpperCasePos.get(ch)) {
                    specialCharsCount++;
                }
            }
        }
        return specialCharsCount;
    }
}
