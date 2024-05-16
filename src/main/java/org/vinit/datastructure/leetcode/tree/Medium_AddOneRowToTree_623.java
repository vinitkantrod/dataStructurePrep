package org.vinit.datastructure.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Medium_AddOneRowToTree_623 {

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
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode t = new TreeNode(val);
            t.left = root;
            return t;
    }
        depth--;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (depth > 1) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            System.out.println(queue.size());
            depth--;
        }
        System.out.println("Q: " + queue.size());
        while (!queue.isEmpty()) {
            TreeNode node= queue.poll();
            System.out.println(node.val);
            TreeNode leftChild = node.left;
            TreeNode rightChild = node.right;
            TreeNode leftNewNode = new TreeNode(val);
            TreeNode rightNewNode = new TreeNode(val);
            node.left = leftNewNode;
            leftNewNode.left = leftChild;
            node.right = rightNewNode;
            rightNewNode.right = rightChild;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(2);
        t.left.left = new TreeNode(3);
        t.left.right = new TreeNode(1);
//        t.left.right.left = new TreeNode(10);
        TreeNode response = addOneRow(t, 1, 3);
    }
}
