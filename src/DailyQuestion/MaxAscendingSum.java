package DailyQuestion;

public class MaxAscendingSum {

    /**
     * 返回 nums 中一个 升序 子数组的最大可能元素和。
     *
     * 输入：nums = [10,20,30,5,10,50]
     * 输出：65
     *
     * 就是找递增子序列，然后将sum值与max值进行比较
     * 找出最大的那个
     *
     * @param nums
     * @return
     */

    public int maxAscendingSum(int[] nums) {
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] < nums[i]){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
