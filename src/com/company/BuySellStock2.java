package com.company; /**
 * @program: dpRush
 * @author: mengzy 18306299232@163.com
 * @create: 2020-08-27 00:06
 **/

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 */

/**
 * 状态转移 ，存在两个状态：持有股票或者持有现金
 * dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+price[i])
 * dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-price[i])
 */
public class BuySellStock2 {
    public int maxProfit(int[] prices) {
        /*买卖股票的最佳时机*/
        int n = prices.length;
        int[][] dp = new int[n][n];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            /*持有现金*/
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][0] - prices[i]);

        }
        return dp[n - 1][0];

    }
}
