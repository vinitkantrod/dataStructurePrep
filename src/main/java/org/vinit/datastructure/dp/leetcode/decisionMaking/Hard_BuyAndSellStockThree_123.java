package org.vinit.datastructure.dp.leetcode.decisionMaking;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Hard_BuyAndSellStockThree_123 {

    public static int maxProfit(int[] prices) {
        int t1Cost = Integer.MAX_VALUE;
        int t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0;
        int t2Profit = 0;
        for (int i : prices) {
            t1Cost = Math.min(t1Cost, i);
            t1Profit = Math.max(t1Profit, i - t1Cost);
            t2Cost = Math.min(t2Cost, i - t1Profit);
            t2Profit = Math.max(t2Profit, i - t2Cost);
            System.out.println(i + ":: " + t1Cost + "_" + t1Profit+", "+t2Cost+"_"+t2Profit);
        }
        return t2Profit;
//        int maxProfit = 0;
//        int minPrice = Integer.MAX_VALUE;
//        Boolean isStockInHand = false;
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
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
//                        int profilt = prices[price] - minPrice;
//                        minPrice = Integer.MAX_VALUE;
//                        isStockInHand = false;
//                        heap.offer(profilt);
//                        if (heap.size() > 2) {
//                            heap.poll();
//                        }
//                    }
//                }
//            }
//        }
//        while (heap.size() > 0) {
//            maxProfit += heap.poll();
//        }
//        return maxProfit;
    }
    public static void main(String[] args) {
//        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
//        System.out.println(maxProfit(new int[]{1,30,1,5,0,10,1,14}));
//        System.out.println(maxProfit(new int[]{1,30,19,18,17,16,15,14}));
        System.out.println(maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}
