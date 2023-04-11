package DP;

public class Change_518 {

    /**
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     *
     * 示例 1:
     * 输入: amount = 5, coins = [1, 2, 5]
     * 输出: 4
     * 解释: 有四种方式可以凑成总金额:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     *
     * 看见有无限个，就可以想到是完全背包问题
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins){
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        //遍历物品
        for (int i = 0; i < coins.length; i++) {
            //遍历价值，一定要从小到大遍历，因为是完全背包问题，允许重复。如果是01背包问题，就从大到小遍历。
            for (int j = coins[i]; j < amount; j++) {
                //求多少种，一般用这个递归公式
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
