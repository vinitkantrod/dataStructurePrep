package org.vinit.datastructure.leetcode.array.twoPointers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Medium_LongestSubArrayWithDiffLessThanLimit_1438 {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int maxLength = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for (int right = 0; right < nums.length; right++) {
            minHeap.offer(new int[]{nums[right], right});
            maxHeap.offer(new int[]{nums[right], right});
            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                left = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;
                while (maxHeap.peek()[1] < left) {
                    maxHeap.poll();
                }
                while (minHeap.peek()[1] < left) {
                    minHeap.poll();
                }
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;

    }
}
