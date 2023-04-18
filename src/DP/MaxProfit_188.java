package DP;

public class MaxProfit_188 {

    /**
     * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1： 输入：k = 2, prices = [2,4,1] 输出：2 解释：在第 1 天 (股票价格 = 2) 的时候买入，
     * 在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2。
     *
     * 这道题与121 122 123一样，只不过把交易数换成了k
     * 同样共有2 * k + 1种情况
     * 遍历一下就行
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length == 0){
            return 0;
        }
        //共有2*k+1种情况
        int condition = 2 * k + 1;
        int[][] dp = new int[prices.length][condition];
        //初始化
        for(int i = 1; i < condition; i += 2){
            dp[0][i] = -prices[0];
        }

        for(int i = 1; i < prices.length; i++){
            //不做任何操作
            dp[i][0] = dp[i - 1][0];
            for(int j = 1; j < condition; j += 2){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);
            }
        }
        return dp[prices.length - 1][condition - 1];
    }
}
