package org.vinit.datastructure.algoexpert.arrays;

import java.util.Arrays;

public class Easy_NonConstructibleChange {

    public int nonConstructibleChange(int[] coins) {
        // Write your code here.
        Arrays.sort(coins);
        int constructibleCoins = 0;
        for (int coin : coins) {
            if (coin > constructibleCoins + 1) return constructibleCoins + 1;
            constructibleCoins += coin;
        }
        return constructibleCoins + 1;
    }
}
