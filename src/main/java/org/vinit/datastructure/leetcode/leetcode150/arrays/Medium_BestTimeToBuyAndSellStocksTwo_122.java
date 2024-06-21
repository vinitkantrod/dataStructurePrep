package org.vinit.datastructure.leetcode.leetcode150.arrays;

public class Medium_BestTimeToBuyAndSellStocksTwo_122 {

    public int maxProfit(int[] prices) {
        int p = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1]) p += prices[i] - prices[i - 1];
        return p;
    }
}
