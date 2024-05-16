package org.vinit.datastructure.leetcode.graph.disjointSet;

public class Medium_RedundantConnection_684 {

    public int[] findRedundantConnection(int[][] edges) {
        int[] response = new int[2];
        UnionFind uf = new UnionFind(edges.length);
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            if (uf.find(x) == uf.find(y)) {
                response[0] = x;
                response[1] = y;
            } else {
                uf.union(x, y);
            }
        }
        return response;
    }
    class UnionFind {
        int[] parent;
        public UnionFind(int size) {
            parent = new int[size + 1];
            parent[0] = -1;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        public int find(int x) {
            if (x == parent[x]) return x;
            return parent[x] = find(parent[x]);
        }
        public void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return;
            parent[y] = x;
        }
    }
}
