package com.thevalenciandev.algorithms.dp.buysell;

/**
 * 121. Best Time to Buy and Sell Stock https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0; // cannot buy and sell, so no profit to be made
        }

        int minPx = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int buyPx = Math.min(minPx, prices[i - 1]);
            int currentProfit = prices[i] - buyPx;
            if (maxProfit < currentProfit) {
                maxProfit = currentProfit;
            }
            minPx = buyPx;
        }

        return maxProfit;
    }

}
