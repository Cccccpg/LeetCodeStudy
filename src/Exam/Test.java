package Exam;

import java.util.HashMap;
import java.util.List;

public class Test {
    public static int punishmentNumber(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            String numStr = Integer.toString(i * i);
            int len = numStr.length();
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= len; j++) {
                int num = Integer.parseInt(numStr.substring(j - 1, len));
                if (num <= n && dp[num] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[num] + i);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(punishmentNumber(10));
    }
}
