package org.vinit.datastructure.dp.leetcode.decisionMaking;

public class Easy_BestTimeToBuyAndSellStock_121 {

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price = 0; price < prices.length - 1; price++) {
            if (prices[price] < minPrice) minPrice = prices[price];
            else if (prices[price] - minPrice > maxProfit) maxProfit = prices[price] - minPrice;
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
