package org.vinit.practice;

import java.util.*;

public class LoopTest {

    public static class Node {
        int val;
        Node left;
        Node right;
        public Node(int v) {
            this.val = v;
            this.left = null;
            this.right = null;
        }
        public Node(int v, Node l, Node r) {
            this.val =v;
            this.left = l;
            this.right = r;
        }
    }
    public static void binaryTree(Node root) {
        // initialise data
        List<String[]> inorder = new ArrayList<>();
        int level = 0;
        int position = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        // calculate Inorder and levels of nodes
        getInOrder(root, inorder, level, position, map);

        // print the tree
        printBT(inorder, map);
    }
    private static int getInOrder(Node root, List<String[]> inorder, int level, int pos, Map<Integer, List<Integer>> map)  {
        if (root == null) {
            inorder.add(new String[]{"x", pos + ""});
            map.computeIfAbsent(level, k -> new ArrayList<>());
            map.get(level).add(inorder.size() - 1);
            return pos + 1;
        } else {
            int leftPos = getInOrder(root.left, inorder, level + 1, pos, map);
            inorder.add(new String[]{"" + root.val, leftPos + ""});
            leftPos += String.valueOf(root.val).length();
            map.computeIfAbsent(level, k -> new ArrayList<>());
            map.get(level).add(inorder.size() - 1);
            return getInOrder(root.right, inorder, level + 1, leftPos, map);
        }
    }
    private static void printBT(List<String[]> inorder, Map<Integer, List<Integer>> map) {
        int level = 0;
        int mapSize = map.size();
        while (level < mapSize) {
            List<Integer> indexes = map.get(level);
            int space = 0;
            for (int ind : indexes) {
                String[] data = inorder.get(ind);
                int position = Integer.parseInt(data[2]);
                while (space < position) {
                    System.out.print(" ");
                    space++;
                }
                System.out.print(data[0]);
                space += data[0].length();
            }
            level++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node n52 = new Node(5, null, null);
        Node n22 = new Node(2, null, n52);
        Node n12 = new Node(1, n22, null);
        binaryTree(n12);
        System.out.println("###");
        Node n51 = new Node(5343, null, null);
        Node n21 = new Node(202, null, n51);
        Node n41 = new Node(40232, null, null);
        Node n31 = new Node(32, null, n41);
        Node n11 = new Node(1923, n21, n31);
        binaryTree(n11);
//        Node n5 = new Node(5, null, null);
//        Node n2 = new Node(2, null, n5);
//        Node n4 = new Node(4, null, null);
//        Node n3 = new Node(3, null, n4);
//        Node n1 = new Node(1, n2, n3);
//        binaryTree(n1);
    }
}
