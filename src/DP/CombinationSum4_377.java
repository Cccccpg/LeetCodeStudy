package DP;

public class CombinationSum4_377 {

    /**
     * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
     *
     * 示例:
     * nums = [1, 2, 3]
     * target = 4
     * 所有可能的组合为： (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2) (3, 1)
     *
     * 请注意，顺序不同的序列被视作不同的组合。
     * 因此输出为 7
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //因为是组合问题，所以不同于求种类的问题，两个for循环的顺序要换一下
        for(int i = 0; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                //背包容量要大于物品重量才能加
                if(i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
