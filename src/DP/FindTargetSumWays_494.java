package DP;

public class FindTargetSumWays_494 {

    /**
     * 给你一个整数数组 nums 和一个整数 target 。
     *
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     *
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     *
     * 输入：nums = [1,1,1,1,1], target = 3
     * 输出：5
     * 解释：一共有 5 种方法让最终目标和为 3 。
     * -1 + 1 + 1 + 1 + 1 = 3
     * +1 - 1 + 1 + 1 + 1 = 3
     * +1 + 1 - 1 + 1 + 1 = 3
     * +1 + 1 + 1 - 1 + 1 = 3
     * +1 + 1 + 1 + 1 - 1 = 3
     *
     * 例如：dp[j]，j 为5，
     *
     * 已经有一个1（nums[i]） 的话，有 dp[4]种方法 凑成 容量为5的背包。
     * 已经有一个2（nums[i]） 的话，有 dp[3]种方法 凑成 容量为5的背包。
     * 已经有一个3（nums[i]） 的话，有 dp[2]中方法 凑成 容量为5的背包
     * 已经有一个4（nums[i]） 的话，有 dp[1]中方法 凑成 容量为5的背包
     * 已经有一个5（nums[i]） 的话，有 dp[0]中方法 凑成 容量为5的背包
     *
     * 递推公式：dp[j] = dp[j - nums[i]]
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (((target + sum) & 1) == 1){
            return 0;
        }
        if (Math.abs(target) > sum){
            return 0;
        }
        int bagSize = (target + sum) >> 1;
        int[] dp = new int[bagSize + 1];
        //初始化
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
