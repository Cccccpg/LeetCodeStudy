package Exam;

import java.util.Scanner;

public class WeBank_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] < 0){
                dp[i] = nums[i];
            }else{
                dp[i] = nums[i] + dp[i - 1];
            }
            max = Math.max(dp[i], max);
        }
        int ans = 0;

            if (dp[n - 1] > 0){
                ans += dp[n - 1];
            }
            for (int i = n - 2; i > 0; i--) {
                if (dp[i] < 0 && dp[i - 1] > 0){
                    ans += dp[i - 1];
                    break;
                }
            }
            System.out.println(ans);
        }


}
