package org.vinit.datastructure.tree.leetcode;

import java.util.*;

public class Medium_SmallestStringStartingFromLeaf_988 {

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
    public static String smallestFromLeaf(TreeNode root) {
        List<String> stringList = new ArrayList<>();
        dfs(root, stringList, "");
        System.out.println(Arrays.asList(stringList));
        Collections.sort(stringList);
        return stringList.get(0);

    }

    public static void dfs(TreeNode node, List<String> stringList, String s) {
        if (node == null) return;
        StringBuffer sb = new StringBuffer();
        sb.append((char)(node.val + 97));
        sb.append(s);
        s = sb.toString();
        if (node.left == null && node.right == null) {
            stringList.add(sb.toString());
            return;
        }
        dfs(node.left, stringList, s);
        dfs(node.right, stringList, s);
        s = sb.substring(1);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(0);
        t.left = new TreeNode(1);
        t.left.left = new TreeNode(2);
        t.left.right = new TreeNode(3);
        t.right = new TreeNode(4);
        t.right.left = new TreeNode(3);
        t.right.right = new TreeNode(4);
        System.out.println(smallestFromLeaf(t));
    }
}
