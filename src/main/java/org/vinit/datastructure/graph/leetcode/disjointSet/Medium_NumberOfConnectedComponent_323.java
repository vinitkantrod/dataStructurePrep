package org.vinit.datastructure.graph.leetcode.disjointSet;

public class Medium_NumberOfConnectedComponent_323 {

    static class UnionFind {
        int[] root;
        int[] rank;
        int count;
        public UnionFind(int n) {
            this.root = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
            count = n;
        }
        public int find(int x) {
            if (x == root[x]) return x;
            return root[x] = find(root[x]);
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else if (rank[rootY] < rank[rootX]) {
                    root[rootY] = rootX;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }
    }
    public static int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count;
    }

    public static void main(String[] args) {
        System.out.println(countComponents(5, new int[][]{{0,1},{3,4},{1,2}}));
        System.out.println(countComponents(5, new int[][]{{0,1},{3,4},{1,2},{2,3}}));
    }
}
