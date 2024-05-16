package org.vinit.datastructure.leetcode.leetcode75.stack;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Stack;

public class Medium_RemovingStarFromString_2390 {

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '*') stack.pop();
            else stack.push(ch);
        }
        System.out.println(stack);
        String str = "";
        while (!stack.isEmpty()) {
            str = String.valueOf(stack.pop()).concat(str);
        }
        return str;
    }
}
