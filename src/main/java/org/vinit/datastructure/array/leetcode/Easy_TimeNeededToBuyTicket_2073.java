package org.vinit.datastructure.array.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Easy_TimeNeededToBuyTicket_2073 {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        // initially solved with queue but later reduced it to simple formula
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) time += Math.min(tickets[i], tickets[k]);
            else time += Math.min(tickets[k] - 1, tickets[i]);
        }
        return time;
    }
    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{2,3,2}, 2));
        System.out.println(timeRequiredToBuy(new int[]{5,1,1,1}, 0));
    }
}
