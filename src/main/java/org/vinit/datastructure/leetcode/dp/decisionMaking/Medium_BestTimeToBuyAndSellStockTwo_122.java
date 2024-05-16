package org.vinit.datastructure.leetcode.dp.decisionMaking;

public class Medium_BestTimeToBuyAndSellStockTwo_122 {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1] ) profit += prices[i] - prices[i - 1];
        }
        return profit;
        // Complex Self Own
//        int minPrice = Integer.MAX_VALUE;
//        int maxProfit = 0;
//        Boolean isStockInHand = false;
//        for (int price = 0; price < prices.length; price++) {
//            if (!isStockInHand) {
//                minPrice = prices[price];
//                isStockInHand = true;
//            } else {
//                if (prices[price] < minPrice) minPrice = prices[price];
//                else{
//                    if (price + 1 == prices.length ||
//                            prices[price + 1] < prices[price])
//                    {
//                        maxProfit += prices[price] - minPrice;
//                        minPrice = Integer.MAX_VALUE;
//                        isStockInHand = false;
//                    }
//                }
//            }
//        }
//        return maxProfit;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,1,5,3,6,9}));
    }
}
