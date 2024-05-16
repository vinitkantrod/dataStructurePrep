package org.vinit.datastructure.leetcode.tree;

public class Medium_CheckIfTwoExpressionTreeAreEquivalent_1612 {

    public class Node {
        char val;
        Node left;
        Node right;
        Node() {}
        Node(char val) { this.val = val; }
        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean checkEquivalence(Node root1, Node root2) {
        int[] map = new int[26];
        addToMap(root1, map, 1);
        addToMap(root2, map, -1);
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
    private void addToMap(Node root, int[] map, int value) {
        if (root == null) return;
        if (root.val <= 'z' && root.val >= 'a') {
            map[root.val - 'a'] += value;
        }
        addToMap(root.left, map, value);
        addToMap(root.right, map, value);
    }
}
