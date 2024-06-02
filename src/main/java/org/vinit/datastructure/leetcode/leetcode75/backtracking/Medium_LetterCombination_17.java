package org.vinit.datastructure.leetcode.leetcode75.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Medium_LetterCombination_17 {
    Map<Character, String> map = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno",
            '7',"pqrs",'8',"tuv",'9',"wxyz");
    List<String> combination = new ArrayList<>();
    String phone;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return combination;
        phone = digits;
        backtrack(0, new StringBuilder());
        return combination;
    }

    private void backtrack(int index, StringBuilder sb) {
        if (sb.length() == phone.length()) {
            combination.add(sb.toString());
            return;
        }
        String possibleLetters = map.get(phone.charAt(index));
        for (char c : possibleLetters.toCharArray()) {
            sb.append(c);
            backtrack(index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
