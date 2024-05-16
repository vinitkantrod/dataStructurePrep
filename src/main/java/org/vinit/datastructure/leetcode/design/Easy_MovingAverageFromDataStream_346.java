package org.vinit.datastructure.leetcode.design;

import java.util.*;

public class Easy_MovingAverageFromDataStream_346 {

    static class MovingAverage {

        Deque<Integer> queue = new ArrayDeque<Integer>();
        int size, windowSum = 0,count = 0;
        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            count++;
            queue.add(val);
            int tail = count > size ? queue.poll() : 0;
            windowSum = windowSum - tail + val;
            return windowSum * 1.0 / Math.min(size, count);
        }
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}
