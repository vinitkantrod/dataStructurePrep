package org.vinit.datastructure.dp.leetcode.decisionMaking;

public class Medium_BestTimeToBuyAndSellStockWithTransactionFee_714 {

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;
        int buy = prices[0];
        int sell = 0;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            buy = Math.min(buy, prices[i] - profit);
            sell = Math.max(profit, prices[i] - buy - fee);
            profit = sell;
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9}, 2));
        System.out.println(maxProfit(new int[]{1,3,7,5,10,3}, 3));
    }
}
