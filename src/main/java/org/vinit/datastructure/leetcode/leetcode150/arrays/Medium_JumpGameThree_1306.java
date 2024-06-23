package org.vinit.datastructure.leetcode.leetcode150.arrays;

public class Medium_JumpGameThree_1306 {
    public boolean canReach(int[] arr, int start) {
        Boolean[] visited = new Boolean[arr.length];
        return dfs(arr, start, visited);
    }
    private boolean dfs(int[] arr, int p, Boolean[] visited) {
        if (p < 0 || p >= arr.length || visited[p]) return false;
        if (arr[p] == 0) return true;
        visited[p] = true;
        return dfs(arr, p + arr[p], visited) || dfs(arr, p - arr[p], visited);
    }
}
