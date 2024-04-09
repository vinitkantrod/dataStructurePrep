package org.vinit.datastructure.dp.leetcode.decisionMaking;

public class Medium_BestTimeToBuyAndSellStockWithCooldown_309 {
    int[] prices;
    public int maxProfit(int[] prices) {
//        this.prices = prices;
        // time limit exceeded
//        return dp(0, false);

        // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solutions/240097/come-on-in-you-will-not-regret-most-general-java-code-like-all-other-dp-solutions/
        if(prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int[] M = new int[n];
        int maxDiff = Integer.MIN_VALUE; // M[j - 2] - prices[j]
        for(int i = 0; i < n; i++){
            if(i < 2) maxDiff = Math.max(maxDiff, -prices[i]);
            if(i == 0) M[0] = 0;
            else if(i == 1) M[1] = Math.max(prices[1] - prices[0], 0);
            else{
                M[i] = Math.max(M[i - 1], maxDiff + prices[i]);
                maxDiff = Math.max(maxDiff, M[i - 2] - prices[i]);
            }
        }

        return M[n - 1];
    }
    public int dp(int day, Boolean isHolding) {
        if (day >= prices.length) return 0;
        int doNothing = dp(day + 1, isHolding);
        int doSomething;
        if (isHolding) {
            doSomething = prices[day] + dp(day + 2, false);
        } else {
            doSomething = -prices[day] + dp(day + 1, true);
        }
        return Math.max(doNothing, doSomething);
    }
}
