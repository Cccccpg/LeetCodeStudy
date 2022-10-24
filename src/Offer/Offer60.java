package Offer;

import java.util.Arrays;

public class Offer60 {


    /**
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
     * 输入n，打印出s的所有可能的值出现的概率。
     *
     * 输入: 1
     * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
     *
     *
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        //因为最后的结果只与前一个动态转移数组有关，所以只需要设置一个一维转移数组
        //原本dp[i][j]表示的是前i个骰子点数之和为j的概率，现在只需要最后的状态数组。所以只用一个一维数组dp[j]表示n个骰子下每个结果的概率
        //初始是1个骰子的情况下只有六种结果
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        //从第2个骰子开始，这里n表示n个骰子，先从第2个的情况算起，然后逐步求n个
        //i表示i个骰子时的结果
        for (int i = 2; i <= n; i++) {
            //每次的点数之和的范围会有变化，点数之和的值最大是i * 6，最小是i * 1，i之前的结果是不会出现的
            double[] temp = new double[5 * n + 1];
            //从第i - 1个骰子的点数之和的值入手，计算第i个骰子的点数之和数组的值
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    //增加骰子的个数到 i 时，i-1个骰子的第j个取值会对拥有i个骰子时的第j+k个取值产生影响
                    temp[j + k] += dp[j] / 6.0;
                }
            }
            dp = temp;
        }
        return dp;
    }
}
