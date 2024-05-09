package org.vinit.datastructure.design;

import java.util.LinkedList;
import java.util.Queue;

public class Easy_NumberOfRecentCall_933 {

    class RecentCounter {

        Queue<Integer> queue;
        Integer TIME_CONSTANT = 3000;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - TIME_CONSTANT) queue.poll();
            return queue.size();
        }
    }
}
