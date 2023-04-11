package DP;

public class LastStoneWeightII_1049 {

    public int lastStoneWeightII(int[] stones){
        int sum = 0, target = 0;
        for (int stone : stones) {
            sum += stone;
        }
        target = sum >> 1;
        int[][] dp = new int[stones.length][target + 1];
        //初始化
        for (int j = 0; j <= target; j++) {
            dp[0][j] = stones[j];
        }
        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= stones[i]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i] + stones[i]]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - 2 * dp[stones.length - 1][target];
    }
}
