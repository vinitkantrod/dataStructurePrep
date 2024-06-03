package org.vinit.datastructure.leetcode.leetcode75.heap;

import java.util.PriorityQueue;

public class Medium_KthLargestElementInArray_215 {
    public int findKthLargest(int[] nums, int k) {
        // MAX Heap
//        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
        // MIN Heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : nums) {
            heap.offer(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}
