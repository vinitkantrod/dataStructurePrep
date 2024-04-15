package org.vinit.datastructure.tree.leetcode;

public class Medium_SumRootToLeafNode_129 {

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
    static int maxSum = 0;
    public static int sumNumbers(TreeNode root) {
//        dfs(root, new StringBuilder());
        simpleDfs(root, 0);
        return maxSum;
    }
    private static void simpleDfs(TreeNode node, int currNumber) {
        if (node != null) {
            currNumber = currNumber * 10 + node.val;
            if (node.left == null && node.right == null) {
                maxSum += currNumber;
            }
            simpleDfs(node.left, currNumber);
            simpleDfs(node.right, currNumber);
        }
    }

    private static void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            Integer parseInt = Integer.parseInt(sb.toString());
            maxSum += parseInt;
            sb.delete(sb.toString().length() - 1, sb.toString().length());
        } else {
            dfs(node.left, sb);
            dfs(node.right, sb);
            sb.delete(sb.toString().length() - 1, sb.toString().length());
        }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(9);
        t.right = new TreeNode(0);
        t.left.left = new TreeNode(5);
        t.left.right = new TreeNode(1);
        t.left.left.left = new TreeNode(2);
        t.left.left.right = new TreeNode(1);
        System.out.println(sumNumbers(t));
    }
}
