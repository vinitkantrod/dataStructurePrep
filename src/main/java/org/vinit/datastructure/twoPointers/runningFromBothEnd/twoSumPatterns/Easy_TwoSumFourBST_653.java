package org.vinit.datastructure.twoPointers.runningFromBothEnd.twoSumPatterns;

import java.util.ArrayList;
import java.util.List;

public class Easy_TwoSumFourBST_653 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int v) {this.val = v;}
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<>();
        getInOrder(root, inOrder);
        int left = 0;
        int right = inOrder.size() - 1;
        while (left < right) {
            if (inOrder.get(left) + inOrder.get(right) == k) {
                return true;
            } else if (inOrder.get(left) + inOrder.get(right) < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public void getInOrder(TreeNode root, List<Integer> inOrder) {
        if (root != null) {
            getInOrder(root.left, inOrder);
            inOrder.add(root.val);
            getInOrder(root.right, inOrder);
        }
    }
}
