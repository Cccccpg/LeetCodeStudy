package DP;

public class CanPartition_416 {

    public boolean canPartition(int[] nums){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1){
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        //如果使用一维dp数组，物品数量放在外层，那么内层就该倒序遍历
        //因为这样才能保证每一个元素不可重复放入
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j > nums[i]; j--) {
                dp[j] = Math.max(dp[j - 1], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
