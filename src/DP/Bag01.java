package DP;

public class Bag01 {

    /**
     * 背包最大重量4，
     * 物品0 重 1，价值 15
     * 物品1 重 3，价值 20
     * 物品2 重 4，价值 30
     * 求最大价值
     *
     * 找到递推公式
     * dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight(i)] + value(i))
     * @param goods
     * @param bagSize
     * @return
     */
    public int bag01(int[][] goods, int bagSize){
        int[][] dp = new int[goods.length][bagSize + 1];
        //初始化
        for (int j = 1; j <= bagSize; j++) {
            if (goods[0][0] <= j){
                dp[0][j] += goods[0][1];
            }else{
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < goods.length; i++) {
            for (int j = 1; j <= bagSize ; j++) {
                if (goods[i][0] <= j){
                    //此时还有空间可以放得下
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - goods[i][0]] + goods[i][1]);
                }else{
                    //当背包容量都没有当前物品goods[i][1]大的时候，此时不放入物品
                    //此时最大的价值就是dp[i - 1][j]的值
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[goods.length - 1][bagSize];
    }
}
