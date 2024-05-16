package org.vinit.datastructure.leetcode.graph.disjointSet;

import java.util.Arrays;

public class Medium_NumberOfProvinces_547 {

    static class DisjointSet {
        int[] root;
        int[] rank;
        int count;
        public DisjointSet(int n) {
            this.root = new int[n];
            this.rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        private int find(int x) {
            if (x == root[x]) return x;
            return root[x] = find(root[x]);
//            if (root[x] != x) {
//                root[x] = find(root[x]);
//            }
//            return root[x];
        }
        public void union(int x, int y) {
            System.out.println("UNION: " + x + "_" + y);
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
           count--;
            System.out.println(Arrays.toString(root));
            System.out.println(Arrays.toString(rank));
        }


        public int findUniqueRoot() {
            return count;
//            System.out.println(Arrays.toString(root));
//            System.out.println(Arrays.toString(rank));
//            Set<Integer> uniqueRootSet = new HashSet<>();
//            for (int i = 0; i < root.length; i++) {
//                uniqueRootSet.add(root[i]);
//            }
//            return uniqueRootSet.size();
        }
    }
    public static int findCircleNum(int[][] isConnected) {
//        int n = isConnected.length;
//        DisjointSet ds = new DisjointSet(n);
//        int connectedComponent = n;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (isConnected[i][j] == 1 && ds.find(i) != ds.find(j)) {
//                    connectedComponent--;
//                    ds.union(i, j);
//                }
//            }
//        }
//        return connectedComponent;
        if (isConnected == null || isConnected.length == 0) return 0;
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    ds.union(i, j);
                }
            }
        }
        return ds.count;
    }

    public static void main(String[] args) {
//        System.out.println(findCircleNum(new int[][]{{1,1,0},{0,1,0},{0,0,1}}));
//        System.out.println(findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
//        System.out.println(findCircleNum(new int[][]{{1,0,1},{0,1,0},{1,1,1}}));
        System.out.println(findCircleNum(new int[][]
                {
                        {1,1,0,0,0,0,0,1,0,1},
                        {1,1,0,0,0,0,0,0,0,0},
                        {0,0,1,0,0,0,1,0,0,0},
                        {0,0,0,1,0,0,0,0,0,0},
                        {0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,1,0,0,0,0},
                        {0,0,1,0,0,0,1,1,0,0},
                        {1,0,0,0,0,0,1,1,0,0},
                        {0,0,0,0,0,0,0,0,1,1},
                        {1,0,0,0,0,0,0,0,1,1}
                }
        ));
        // {0,1}{0,7}{0,9}{1,0}{2,6}{3}{4}{5}{6,2}{7,6}{7,1}{7,6}{8,9}{9,1}{9,8}
        // {0,1,2,6,7,8,9}{3}{4}{5}
    }

}
