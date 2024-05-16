package org.vinit.datastructure.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_RevealCardInIncreasingOrder_950 {

    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        int[] result = new int[N];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) queue.offer(i);
        Arrays.sort(deck);
        for (int i = 0; i < N; i++) {
            result[queue.poll()] = deck[i];
            queue.offer(queue.poll());
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
