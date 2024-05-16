package org.vinit.datastructure.leetcode.dp.decisionMaking;

public class Hard_BuyAndSellStockFour_188 {

    int[] prices;
    int[][][] memo;
    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        this.memo = new int[prices.length][k + 1][2];
        return dp(0, k, 0);
    }
    public int dp(int i, int transaction, int holding) {
        if (transaction == 0 || i == this.prices.length) {
            return 0;
        }
        if (this.memo[i][transaction][holding] == 0) {
            int doNothing = dp(i + 1, transaction, holding);
            int doSomething;
            if (holding == 1) {
                // Sell Stock
                doSomething = this.prices[i] + dp(i + 1, transaction - 1, 0);
            } else {
                doSomething = -this.prices[i] + dp(i + 1, transaction, 1);
            }
            this.memo[i][transaction][holding] = Math.max(doSomething, doNothing);
        }
        return this.memo[i][transaction][holding];
    }

    public static void main(String[] args) {

    }
}
