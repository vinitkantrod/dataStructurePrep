package org.vinit.datastructure.leetcode.tree;

import java.util.*;

public class Medium_VerticalOrderTraversal_314 {

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

    class  Pair {
        int key;
        int val;
        public Pair(int x, int y) {
            this.key = x;
            this.val = y;
        }
    }
    Map<Integer, ArrayList<Pair>> columnTable = new HashMap();
    int minColumn = 0, maxColumn = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList();
        if (root == null) {
            return output;
        }

        this.DFS(root, 0, 0);

        // Retrieve the resuts, by ordering by column and sorting by row
        for (int i = minColumn; i < maxColumn + 1; ++i) {

            Collections.sort(columnTable.get(i), new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return p1.key - p2.key;
                }
            });

            List<Integer> sortedColumn = new ArrayList();
            for (Pair p : columnTable.get(i)) {
                sortedColumn.add(p.val);
            }
            output.add(sortedColumn);
        }

        return output;
    }
    private void DFS(TreeNode node, Integer row, Integer column) {
        if (node == null)
            return;

        if (!columnTable.containsKey(column)) {
            this.columnTable.put(column, new ArrayList<Pair>());
        }

        this.columnTable.get(column).add(new Pair(row, node.val));
        this.minColumn = Math.min(minColumn, column);
        this.maxColumn = Math.max(maxColumn, column);
        // preorder DFS traversal
        this.DFS(node.left, row + 1, column - 1);
        this.DFS(node.right, row + 1, column + 1);
    }

}
