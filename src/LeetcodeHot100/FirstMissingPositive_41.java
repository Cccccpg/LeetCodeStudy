package LeetcodeHot100;

public class FirstMissingPositive_41 {

    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     *
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     *
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     *
     * 遍历整个数组，只选正整数，且小于等于数组长度的数
     * 然后放到对应的数组位置上
     * 遍历新数组，只要数组索引和数组值不一样，那么就说明缺少的就是这个索引数
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && nums[i] <= nums.length){
                ans[nums[i] - 1] = nums[i];
            }
        }
        for(int i = 0; i < ans.length; i++){
            if(ans[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
