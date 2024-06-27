package org.vinit.datastructure.leetcode.leetcode150.stack;

import java.util.Stack;

public class Hard_BasicCalculator_224 {

    public static int calculate(String s) {
        int num = 0;
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + (int) (c - '0');
            } else if (c == '+' || c == '-') {
                result += sign * num;
                num = 0;
                sign = (c == '+') ? 1 : -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * num;
                result *= stack.pop();
                result += stack.pop();
                num = 0;
            }
        }
        return result + (sign * num);
    }

    public static void main(String[] args) {
        System.out.println(calculate("5+3+(30-20)"));
    }
}
