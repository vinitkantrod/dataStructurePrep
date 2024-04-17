package org.vinit.datastructure.leetcode75.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_Dota2Senate_649 {

    public static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        int[] countArr = new int[2];
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') rQueue.offer(i); // R
            else dQueue.offer(i); // D
        }
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            Integer rInt = rQueue.poll();
            Integer dInt = dQueue.poll();
            if (dInt < rInt) {
                dQueue.offer(dInt + n);
            } else {
                rQueue.offer(rInt + n);
            }
            return !rQueue.isEmpty() ? "Radiant" : "Dire";
        }
        if (countArr[0] > countArr[1]) return "Radiant";
        if (countArr[1] > countArr[0]) return "Dire";
        if (senate.charAt(0) == 'R') return "Radiant";
        else return "Dire";
    }

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDDDRR"));
        System.out.println(predictPartyVictory("RD"));
        System.out.println(predictPartyVictory("R"));
        System.out.println(predictPartyVictory("RDDDD"));
        System.out.println(predictPartyVictory("RDRDRD"));
    }
}
