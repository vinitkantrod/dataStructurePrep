package org.vinit.datastructure.stack.leetcode.monotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Hard_LargestRectangleInHistogram_84 {

    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int len = heights.length;
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            System.out.println("Before: " + stack);
            while (stack.peek()  != -1 &&
                    (heights[stack.peek()] > heights[i])) {
                int currHeight = heights[stack.pop()];
                int currWidth = i - stack.peek() - 1;
                System.out.println(currHeight + ", " + currWidth);
                maxArea = Math.max(maxArea, currWidth * currHeight);
            }
            stack.push(i);
            System.out.println("After: " + stack + ", " + maxArea);
        }
        while (stack.peek() != -1) {
            int currHeight = heights[stack.pop()];
            int currWeight = len - stack.peek() - 1;
            maxArea = Math.max(maxArea, currWeight * currHeight);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{6,7,5,2,4,5,9,3}));
    }
}
