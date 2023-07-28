package LeetcodeHot100;

public class MaxSubArray_53 {
    // DP
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max((dp[i - 1] + nums[i]), nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    // 贪心
    public int maxSubArray1(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > max){
                max = sum;
            }
            if(sum <= 0){
                sum = 0;
            }
        }
        return max;
    }
}
