package com.company;

import sun.rmi.server.InactiveGroupException;

/**
 * @description:
 * @author: Meng ZhongYi
 * @create: 2020-08-27 10:49
 **/

/*
 *
 *idea 使用三维状态，有时候想想递归就知道怎么写了
 * dp[][][] 二维：0:持有现金 1:持有股票 三维：0完成0股 1：完成1股 2：完成两股
 **/
public class buySellStock3 {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        /*init*/
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][0][2] = Integer.MIN_VALUE;

        dp[0][1][0] = -prices[0];
        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][1][2] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            /*持有现金，没有卖股*/
            dp[i][0][0] = 0;
            /*未持股，完成一股*/
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] + prices[i]);
            /*未持股，完成两股*/
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] + prices[i]);

            /*持股，完成0股*/
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i][0][0] - prices[i]);
            /*持股，完成1股*/
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i][0][1] - prices[i]);
            /*持股 ，完成两股*/
            dp[i][1][2] = Integer.MIN_VALUE;
        }

        return Math.max(Math.max(dp[n - 1][0][2], dp[n - 1][0][1]), 0);


    }
}
