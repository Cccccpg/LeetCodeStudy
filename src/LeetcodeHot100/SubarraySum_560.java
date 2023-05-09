package LeetcodeHot100;

import java.util.HashMap;

public class SubarraySum_560 {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
     *
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     *
     * 这题不能用滑动窗口来做，因为nums中有负数，如果用滑动窗口做的话，求出的和会越来越小。
     * 所以可以用暴力的方法来做，但是暴力的方法时间复杂度很高O(n^2)
     *
     * 可以考虑用hash表，从最开始的数到第i个数的和记录进hashMap中，
     * 如果hashMap中存在tempSum - k，说明前面一定有和为k的子数组
     * 只需要加上频次就行
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0, tempSum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            tempSum += nums[i];
            if(hashMap.containsKey(tempSum - k)){
                ans += hashMap.get(tempSum - k);
            }
            hashMap.put(tempSum, hashMap.getOrDefault(tempSum, 0) + 1);
        }
        return ans;
    }
}
