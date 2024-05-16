package org.vinit.datastructure.leetcode.leetcode.traversal;

import java.util.HashSet;
import java.util.Set;

public class Medium_NumberOfProvinces_547 {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        int connectedComponent = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && ds.find(i) != ds.find(j)) {
                    connectedComponent--;
                    ds.union(i, j);
                }
            }
        }
        return connectedComponent;
    }
    static class DisjointSet {
        int[] root;
        int[] rank;
        public DisjointSet(int n) {
            this.root = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }
        private int find(int x) {
            if (root[x] != x) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }

        public int findUniqueRoot() {
            Set<Integer> uniqueRootSet = new HashSet<>();
            for (int i = 0; i < root.length; i++) {
                uniqueRootSet.add(root[i]);
            }
            return uniqueRootSet.size();
        }
    }
}
