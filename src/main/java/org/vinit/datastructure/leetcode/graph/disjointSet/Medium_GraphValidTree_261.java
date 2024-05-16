package org.vinit.datastructure.leetcode.graph.disjointSet;

public class Medium_GraphValidTree_261 {

    class UnionFind {

        private int[] parent;
        private int[] size; // We use this to keep track of the size of each set.

        // For efficiency, we aren't using makeset, but instead initialising
        // all the sets at the same time in the constructor.
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int node = 0; node < n; node++) {
                parent[node] = node;
                size[node] = 1;
            }
        }

        // The find method, with path compression. There are ways of implementing
        // this elegantly with recursion, but the iterative version is easier for
        // most people to understand!
        public int find(int A) {
            // Step 1: Find the root.
            int root = A;
            while (parent[root] != root) {
                root = parent[root];
            }
            // Step 2: Do a second traversal, this time setting each node to point
            // directly at A as we go.
            while (A != root) {
                int oldRoot = parent[A];
                parent[A] = root;
                A = oldRoot;
            }
            return root;
        }

        // The union method, with optimization union by size. It returns True if a
        // merge happened, False if otherwise.
        public boolean union(int A, int B) {
            // Find the roots for A and B.
            int rootA = find(A);
            int rootB = find(B);
            // Check if A and B are already in the same set.
            if (rootA == rootB) {
                return false;
            }
            // We want to ensure the larger set remains the root.
            if (size[rootA] < size[rootB]) {
                // Make rootB the overall root.
                parent[rootA] = rootB;
                // The size of the set rooted at B is the sum of the 2.
                size[rootB] += size[rootA];
            }
            else {
                // Make rootA the overall root.
                parent[rootB] = rootA;
                // The size of the set rooted at A is the sum of the 2.
                size[rootA] += size[rootB];
            }
            return true;
        }
    }

    /**
     * Ways to solve it:
     * Graph can be represented as adjancency list, adjacencyMatrix, linked Representation
     * Iterative DFS - Adjacency List, stacks
     * Recursive DFS
     * Iterative BFS - queue, Adjacency List
     * Union Find (BEST)
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree(int n, int[][] edges) {
        // Tree can be formed if Graph has n-1 edges
        if (edges.length != n - 1) return false;
        // Less-number of edges will result in not connected trees
        // more edges would result in cycle
        // As this is undirected graph, A->B->A is atrivial cycle and should be ignored
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            int A = edge[0];
            int B = edge[1];
            if (!uf.union(A, B)) return false;
        }
        return true;
    }
}
