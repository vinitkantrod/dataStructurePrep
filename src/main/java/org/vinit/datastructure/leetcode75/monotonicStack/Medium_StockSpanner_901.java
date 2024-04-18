package org.vinit.datastructure.leetcode75.monotonicStack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class Medium_StockSpanner_901 {

    static class StockSpanner {
        Stack<int[]> stack;
        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int ans = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                System.out.println("I: " + stack.peek()[0] + ", " + stack.peek()[1]);
                ans += stack.pop()[1];
                System.out.println("A: " + ans);
            }
            stack.push(new int[]{price, ans});
            return ans;
        }
    }

    public static void main(String[] args) {
        StockSpanner sp = new StockSpanner();
        sp.next(100);
        sp.next(80);
        sp.next(60);
        sp.next(70);
        sp.next(60);
        sp.next(75);
        sp.next(85);
    }

}
