package DP;

public class NumTrees_96 {
    /**
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     *
     * 输入：n = 3
     * 输出：5
     *
     * 找到状态转移方程
     * dp[3] = dp[2]*dp[0] + dp[1][1]* dp[1][1] + dp[0][2]
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //虽然dp[0]表示空树，但是空树也可以看成一种二叉搜索树
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            if((i & 1) == 0){
                for(int j = i - 1; j >= i / 2; j--){
                    dp[i] += 2 * dp[j] * dp[i - j - 1];
                }
            }else{
                for(int j = i - 1; j > i / 2; j--){
                    dp[i] += 2 * dp[j] * dp[i - j - 1];
                }
                dp[i] += dp[(i - 1) / 2] * dp[(i - 1) / 2];
            }
        }
        return dp[n];
    }
}
