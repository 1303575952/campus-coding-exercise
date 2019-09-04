package array;

public class StockProfit {
    /**
     * 假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
     * 如果你最多只允许完成一次交易(例如,一次买卖股票),设计一个算法来找出最大利润。
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices.length < 2)
            return 0;
        int low = prices[0];
        int max = 0;//代表买卖股票的差价
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - low);
            low = Math.min(low, prices[i]);
        }
        return max;
    }

    /**
     * 假设有一个数组，它的第i个元素是一个给定的股票在第i天的价格。设计一个算法来找到最大的利润。
     * 你可以完成尽可能多的交易(多次买卖股票)。然而，你不能同时参与多个交易(你必须在再次购买前出售股票)。
     *
     * @param prices
     * @return
     */
    public int maxProfit2a(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) res += prices[i] - prices[i - 1];
        }
        return res;
    }

    // 动态规划解法；buy[i]：代表到i天为止，以buy行为结尾的最大利润；sell[i]与rest[i]类似
    // buy[i] = max{ buy[i-1], sell[i-1]-price}
    // sell[i] = max{ sell[i-1], buy[i-1]+price
    public int maxProfit2b(int[] prices) {
        int buy = Integer.MIN_VALUE, sell = 0;
        for (int price : prices) {
            int pre_buy = buy;
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, pre_buy + price);
        }
        return sell;
    }
}
