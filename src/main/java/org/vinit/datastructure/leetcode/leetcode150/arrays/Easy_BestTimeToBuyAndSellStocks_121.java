package org.vinit.datastructure.leetcode.leetcode150.arrays;

public class Easy_BestTimeToBuyAndSellStocks_121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int p = 0; p < prices.length; p++) {
            if (prices[p] < minPrice) minPrice = prices[p];
            else if (prices[p] - minPrice > profit) profit = prices[p] - minPrice;
        }
        return profit;
    }
}
