package org.vinit.datastructure.leetcode75.binaryTreeBFS;

import java.util.LinkedList;
import java.util.Queue;

public class Medium_MaximumLevelSumOfBinaryTree_1161 {
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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int maxSum = 0;
        if (root == null) return 0;
        queue.add(root);
        maxSum = root.val;
        int level = 1;
        int maxSumLevel = level;
        while (!queue.isEmpty()) {
            int count = queue.size();
            int tempSum = 0;
            while (count > 0) {
                TreeNode node = queue.poll();
                tempSum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                count--;
            }
            if (tempSum > maxSum) {
                maxSum = tempSum;
                maxSumLevel = level;
            }
            level++;
        }
        return maxSumLevel;
    }
}
