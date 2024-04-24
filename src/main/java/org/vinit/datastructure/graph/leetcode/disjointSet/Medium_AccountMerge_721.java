package org.vinit.datastructure.graph.leetcode.disjointSet;

import java.util.*;

public class Medium_AccountMerge_721 {

    static class UnionFind {
        int[] representative;
        int[] size;
        public UnionFind(int sz) {
            representative = new int[sz];
            size = new int[sz];
            for (int i = 0; i < sz; i++) {
                representative[i] = i;
                size[i] = 1;
            }
        }
        public int find(int x) {
            if (x == representative[x]) return x;
            return representative[x] = find(representative[x]);
        }
        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootB == rootA) return;
            if(size[rootA] >= size[rootB]) {
                size[rootA] += size[rootB];
                representative[rootB] = rootA;
            } else {
                size[rootB] += size[rootA];
                representative[rootA] = rootB;
            }
        }
    }
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accSize = accounts.size();
        UnionFind uf = new UnionFind(accSize);
        Map<String, Integer> emailGroup = new HashMap<>();
        for (int i = 0; i < accSize; i++) {
            int accountSize = accounts.get(i).size();
            for (int j = 1; j < accountSize; j++) {
                String email = accounts.get(i).get(j);
                String name = accounts.get(i).get(0);
                if (!emailGroup.containsKey(email)) emailGroup.put(email, i);
                else uf.union(i, emailGroup.get(email));
            }
        }
        Map<Integer, List<String>> components = new HashMap<>();
        for (String email : emailGroup.keySet()) {
            int group = emailGroup.get(email);
            int groupRep = uf.find(group);
            if (!components.containsKey(groupRep)) components.put(groupRep, new ArrayList<>());
            components.get(groupRep).add(email);
        }

        List<List<String>> response = new ArrayList<>();
        for (int group : components.keySet()) {
            List<String> emails = components.get(group);
            Collections.sort(emails);
            emails.add(0, accounts.get(group).get(0));
            response.add(emails);
        }
        return response;
    }

    public static void main(String[] args) {
        List<String> j1 = new ArrayList<>(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        List<String> j2 = new ArrayList<>(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        List<String> j3 = new ArrayList<>(Arrays.asList("Mary","mary@mail.com"));
        List<String> j4 = new ArrayList<>(Arrays.asList("John","johnnybravo@mail.com"));
        List<List<String>> req = new ArrayList<>(
                Arrays.asList(j1, j2, j3, j4)
        );
        List<List<String>> resp = accountsMerge(req);
    }
}
