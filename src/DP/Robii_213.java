package DP;

public class Robii_213 {
    /**
     * 与198题相比，就是收尾相连了
     *
     * 分类讨论就行
     *
     * 第一种情况：默认不要最后一个元素
     * 第二种情况：默认不要第一个元素
     *
     * 最后将两个结果相比，取最大值
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int res1 = robRange(nums, 0, nums.length - 2);
        int res2 = robRange(nums, 1, nums.length - 1);
        return Math.max(res1, res2);
    }

    public int robRange(int[] nums, int start, int end){
        if(end - start == 0){
            return nums[start];
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start + 1], nums[start]);
        for(int i = start + 2; i <= end; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
