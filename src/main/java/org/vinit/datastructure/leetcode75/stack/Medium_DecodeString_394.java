package org.vinit.datastructure.leetcode75.stack;

import java.util.Stack;

public class Medium_DecodeString_394 {

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                String str = "";
                String count = "";
                char topChar = stack.peek();
                while (topChar != '[') {
                    str = String.valueOf(stack.pop()).concat(str);
                    if (stack.isEmpty()) break;
                    topChar = stack.peek();
                }
                stack.pop();
                topChar = stack.peek();
                while (Character.isDigit(topChar)) {
                    count = String.valueOf(stack.pop()).concat(count);
                    if (stack.isEmpty()) break;
                    topChar = stack.peek();
                }
                System.out.println("count: " + count);
                String newString = str.repeat(Integer.parseInt(count));
                for (char cc : newString.toCharArray()) stack.push(cc);
                continue;
            }
            stack.push(ch);
            System.out.println(stack);
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = String.valueOf(stack.pop()).concat(result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("10[leetcode]"));
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
