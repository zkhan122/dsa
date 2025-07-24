package SlidingWindow;

import java.util.Arrays;

public class BestTimetoBuySellStock {

    // best profit would be that where you buy at low and sell at high
    // therefore best_profit = max(sell) - min(buy)
    public static int maxProfit(int[] prices) {
        int bestProfit = 0;
        int minBuyPoint = prices[0];

        for (int i = 1; i < prices.length; i++) {
            minBuyPoint = Math.min(minBuyPoint, prices[i]);
            int currentSellPoint = prices[i];
            bestProfit = Math.max(bestProfit, (currentSellPoint - minBuyPoint));
        }
        return bestProfit;

    }

    public static void main(String[] args) {
        int[] prices1 = {10,1,5,6,7,1};
        int[] prices2 = {10,8,7,5,2};

        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
    }
}
