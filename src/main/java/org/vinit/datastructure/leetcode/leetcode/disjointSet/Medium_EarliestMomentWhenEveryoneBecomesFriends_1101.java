package org.vinit.datastructure.leetcode.leetcode.disjointSet;

import java.util.Arrays;
import java.util.Comparator;

public class Medium_EarliestMomentWhenEveryoneBecomesFriends_1101 {

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
    public static int earliestAcq(int[][] logs, int n) {
        UnionFind uf = new UnionFind(n);
        Arrays.sort(logs, Comparator.comparingInt(e -> e[0]));
        for (int[] log : logs) {
            System.out.println(Arrays.toString(log));
            uf.union(log[1], log[2]);
            System.out.println(uf.count);
            if (uf.count == 1) return log[0];
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(earliestAcq(new int[][]{{20190101,0,1},
//                {20190104,3,4},{20190107,2,3},{20190211,1,5},
//                {20190224,2,4},{20190301,0,3},{20190312,1,2},
//                {20190322,4,5}}, 6));
        System.out.println(earliestAcq(new int[][]{{9,3,0},
                {0,2,1},{8,0,1},{1,3,2},{2,2,0},{3,3,1}}, 4));
    }
}
