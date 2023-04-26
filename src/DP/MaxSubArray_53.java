package DP;

import java.util.Scanner;

public class MaxSubArray_53 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(maxSubArray(nums));
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例: 输入: [-2,1,-3,4,-1,2,1,-5,4] 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums){
        /* 方法1：贪心算法
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count <= 0){
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
        */

        //方法2：动态规划
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
