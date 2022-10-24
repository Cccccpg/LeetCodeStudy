package Offer;

public class Offer49 {

    /**
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。
     * 求按从小到大的顺序的第 n 个丑数。
     *
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     *
     * 用三个指针，第一个丑数是1，后面的数都是基于前面的丑数分别乘2 3 5构成
     * 每次添加进去一个当前计算出来的三个丑数中最小的一个
     * 谁计算出来的，谁的指针就往后移动一位
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[index2] * 2, Math.min(dp[index3] * 3, dp[index5] * 5));
            if (dp[index2] * 2 == dp[i]){
                index2++;
            }
            if (dp[index3] * 3 == dp[i]){
                index3++;
            }
            if (dp[index5] * 5 == dp[i]){
                index5++;
            }
        }
        return dp[n - 1];
    }
}
