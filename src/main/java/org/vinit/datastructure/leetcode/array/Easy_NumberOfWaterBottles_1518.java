package org.vinit.datastructure.leetcode.array;

public class Easy_NumberOfWaterBottles_1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int consumedBottles = 0;

        while (numBottles >= numExchange) {
            // Maximum number of times we can consume numExchange
            // number of bottles using numBottles.
            int K = numBottles / numExchange;

            consumedBottles += numExchange * K;
            numBottles -= numExchange * K;

            numBottles += K;
        }

        return consumedBottles + numBottles;
    }
}
