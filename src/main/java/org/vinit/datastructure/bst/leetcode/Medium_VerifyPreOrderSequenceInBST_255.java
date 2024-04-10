package org.vinit.datastructure.bst.leetcode;

import java.util.Stack;

public class Medium_VerifyPreOrderSequenceInBST_255 {

    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int minLimit = Integer.MIN_VALUE;
        for (int num : preorder) {
            while (!stack.isEmpty() && stack.peek() < num) {
                minLimit = stack.pop();
            }
            if (num <= minLimit) return false;
            stack.push(num);
        }
        return true;
    }
}
