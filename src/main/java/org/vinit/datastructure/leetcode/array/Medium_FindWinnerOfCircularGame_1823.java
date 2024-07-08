package org.vinit.datastructure.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

public class Medium_FindWinnerOfCircularGame_1823 {

    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n; i++) q.offer(i);
        while (q.size() > 1) {
            for (int i = 0; i < k - 1; i++) q.offer(q.poll());
            q.poll();
        }
        return q.peek();
    }
}
