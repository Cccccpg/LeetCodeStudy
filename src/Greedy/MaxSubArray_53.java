package Greedy;

public class MaxSubArray_53 {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums){
        int count = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            //记录最大连续和
            if (count > res){
                res = count;
            }
            //当和小于等于0时，其实就是在拖累res了，所以可以直接舍弃
            if (count <= 0){
                count = 0;
            }
        }
        return res;
    }
}
