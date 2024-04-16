package org.vinit.datastructure.tree.leetcode;

import com.sun.source.tree.Tree;

import java.util.*;

public class Medium_PseudoPalindromicPathinBinaryTree_1457 {

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
    static  int count = 0;
    public static int pseudoPalindromicPaths (TreeNode root) {
//        List<String> pathString = new ArrayList<>();
//        dfs(root, pathString, "");
//        int palindromicCount = 0;
//        System.out.println(Arrays.asList(pathString));
//        for (String str : pathString) {
//            Map<Character, Integer> charCount = new HashMap<>();
//            int oddCount = 0;
//            for (char ch : str.toCharArray()) {
//                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
//            }
//            System.out.println("M: " + charCount);
//            for (Map.Entry<Character, Integer> m : charCount.entrySet()) {
//                if (m.getValue() % 2 == 1) oddCount++;
//            }
//            if (oddCount <= 1) palindromicCount++;
//        }
//        return palindromicCount;
        preorder(root, 0);
        return count;
    }

    private static void dfs(TreeNode node, List<String> pathString, String str) {
        if (node == null) return;
        str += node.val + "";
        if (node.left == null && node.right == null) {
            pathString.add(str);
            return;
        }
        dfs(node.left, pathString, str);
        dfs(node.right, pathString, str);
    }
    public static void preorder(TreeNode node, int path) {
        if (node != null) {
            // compute occurences of each digit
            // in the corresponding register
            path = path ^ (1 << node.val);
            // if it's a leaf check if the path is pseudo-palindromic
            if (node.left == null && node.right == null) {
                // check if at most one digit has an odd frequency
                if ((path & (path - 1)) == 0) {
                    ++count;
                }
            }
            preorder(node.left, path);
            preorder(node.right, path) ;
        }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(2);
        t.right = new TreeNode(1);
        t.left.left = new TreeNode(2);
        t.left.right = new TreeNode(1);
        t.right.right = new TreeNode(1);
        System.out.println(pseudoPalindromicPaths(t));
    }
}
