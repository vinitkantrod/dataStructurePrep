package org.vinit.datastructure.leetcode.leetcode75.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Medium_SmallestNumberInInfiniteSet_2336 {
    class SmallestInfiniteSet {

        Set<Integer> set;
        PriorityQueue<Integer> heap;

        public SmallestInfiniteSet() {
            set = new HashSet<>();
            heap = new PriorityQueue<>();
            for (int i = 1; i < 1001; i++) {
                heap.offer(i);
                set.add(i);
            }
        }

        public int popSmallest() {
            int s = heap.poll();
            set.remove(s);
            return s;
        }

        public void addBack(int num) {
            if (!set.contains(num)) {
                set.add(num);
                heap.offer(num);
            }
        }
    }

}
