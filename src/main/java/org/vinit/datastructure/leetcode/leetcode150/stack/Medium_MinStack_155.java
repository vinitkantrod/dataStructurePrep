package org.vinit.datastructure.leetcode.leetcode150.stack;

import java.util.Stack;

public class Medium_MinStack_155 {

    class MinStack {
        Stack<int[]> stack;
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new int[]{val, val});
                return;
            }
            int[] top = stack.peek();
            stack.push(new int[]{val, Math.min(top[1], val)});
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }

}
