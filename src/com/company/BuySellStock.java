package com.company; /**
 * @program: dpRush
 * @author: mengzy 18306299232@163.com
 * @create: 2020-08-26 23:19
 * <p>
 * 假设你有一个数组，其中第i 个元素是股票在第i 天的价格。
 * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
 */

/**
 * 假设你有一个数组，其中第i 个元素是股票在第i 天的价格。
 * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
 */

/**
 * idea: 保存当前[0至i-1]的最小值,然后尝试着以今天卖股票，求的是区间差最大值
 *
 *
 */
public class BuySellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;


    }
}
