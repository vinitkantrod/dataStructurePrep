package org.vinit.datastructure.hackerrank;

public class Medium_IsTreeABST {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static boolean checkBST(Node root) {
        return isValidTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isValidTree(Node root, int min, int max) {
        if (root == null) return true;
        if (root.data <= min || root.data >= max) return false;
        return isValidTree(root.left, min, root.data) && isValidTree(root.right, root.data, max);
    }

    public static void main(String[] args) {
        Node t = new Node(5);
        t.left = new Node(3);
        t.left.left = new Node(1);
        t.left.right = new Node(4);
        t.right = new Node(8);
        t.right.left = new Node(6);
        System.out.println(checkBST(t));
    }
}
