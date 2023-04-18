package DP;

public class MaxProfit_309 {

    /**
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
     *
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     *
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 示例:
     *
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     *
     * 共有四种情况
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            //达到可以买入股票的状态：1.昨天持有股票 1.1.昨天是冷冻期 1.2.昨天保持卖出状态
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3], dp[i - 1][1]) - prices[i]);
            //达到保持卖出股票的状态：1.前一天就是这个状态 2.前一天是第四个状态，也即冷冻期
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            //达到今天就可以卖出的状态：昨天肯定是持有股票
            dp[i][2] = dp[i - 1][0] + prices[i];
            //达到冷冻期状态：昨天一定卖出了股票
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][3], Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]));
    }
}
