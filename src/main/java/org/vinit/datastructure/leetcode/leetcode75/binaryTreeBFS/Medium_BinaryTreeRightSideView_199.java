package org.vinit.datastructure.leetcode.leetcode75.binaryTreeBFS;

import java.util.*;

public class Medium_BinaryTreeRightSideView_199 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            TreeNode lastNodeVal = null;
            while (count > 0) {
                lastNodeVal = queue.poll();
                if (lastNodeVal.left != null) queue.add(lastNodeVal.left);
                if (lastNodeVal.right != null) queue.add(lastNodeVal.right);
                count--;
            }
            result.add(lastNodeVal.val);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(5);
        t.right.left = new TreeNode(4);
        System.out.println(Arrays.asList(rightSideView(t)));
    }
}
