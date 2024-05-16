package org.vinit.datastructure.leetcode.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Medium_MaximizeHappinessOfSelectedChildren_3075 {

    public static long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : happiness) maxHeap.offer(i);
        int turns = 0;
        long happinessCount = 0;
        for (int i = 0; i < k ; i++) {
            happinessCount += Math.max(maxHeap.poll() - turns, 0);
            turns++;
        }
        return happinessCount;
    }

    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[]{1,2,3,4,5}, 2));
        System.out.println(maximumHappinessSum(new int[]{1,2,3}, 2));
        System.out.println(maximumHappinessSum(new int[]{1,1,1,1,1}, 2));
        System.out.println(maximumHappinessSum(new int[]{2,3,4,5}, 1));
        System.out.println(maximumHappinessSum(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }
}
