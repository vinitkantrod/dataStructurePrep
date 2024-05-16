package org.vinit.datastructure.leetcode.graph.disjointSet;

public class Hard_RedundantConnectionTwo_685 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] opt1 = null, opt2 = null;
        QuickUnion qu = new QuickUnion(edges.length+1);
        for (int[] e : edges) {
            int start = e[0];
            int end = e[1];

            if (qu.hasMultipleParents(end)) opt1 = e;
            else if (qu.hasCircle(start, end)) opt2 = e;
            else qu.union(start, end);
        }

        if (opt1 == null) return opt2;
        if (opt2 == null) return opt1;

        for (int[] e : edges) if (e[1] == opt1[1]) return e;

        return new int[2];
    }
    class QuickUnion {
        int[] parents;

        public QuickUnion(int n) {
            parents = new int[n];

            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int root(int i) {
            while (i != parents[i]) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int rooti = root(i);
            int rootj = root(j);

            parents[rootj] = rooti;
        }

        public boolean hasCircle(int i, int j) {
            return root(i) == root(j);
        }

        public boolean hasMultipleParents(int j) {
            return root(j) != j;
        }
    }
}
