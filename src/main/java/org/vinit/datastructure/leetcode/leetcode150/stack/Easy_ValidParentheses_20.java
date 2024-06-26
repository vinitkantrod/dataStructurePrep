package org.vinit.datastructure.leetcode.leetcode150.stack;

import java.util.Map;
import java.util.Stack;

public class Easy_ValidParentheses_20 {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of(')','(','}','{',']', '[');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                char topE = stack.isEmpty() ? '#' : stack.pop();
                if (topE != map.get(c)) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
