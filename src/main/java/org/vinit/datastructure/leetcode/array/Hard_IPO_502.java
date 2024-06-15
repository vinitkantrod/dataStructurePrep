package org.vinit.datastructure.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Hard_IPO_502 {

    class Project implements Comparable<Project> {
        int capital, profit;
        public Project(int c, int p) {
            this.capital = c;
            this.profit = p;
        }
        @Override
        public int compareTo(Project o) {
            return capital - o.capital;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) projects[i] = new Project(capital[i], profits[i]);
        Arrays.sort(projects);
        PriorityQueue<Integer> q = new PriorityQueue<>(n, Collections.reverseOrder());
        int ptr = 0;
        for (int i = 0; i < k; i++) {
            while (ptr < n && projects[ptr].capital <= w)
                q.add(projects[ptr++].profit);
            if (q.isEmpty()) break;
            w += q.poll();
        }
        return w;
    }
}
