package LeetcodeHot100;

public class MajorityElement_169 {

    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 要求：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
     * 输入：nums = [2,2,1,1,1,2,2]
     * 输出：2
     *
     * 方法一：可用HashMap来做
     * 方法二：用摩尔投票法
     * 相当于用一个count来计数，如果有相同的数，count就加一，不同就减一
     * 因为要找出现次数大于数组长度一般的元素，哪怕就算一换一
     * 最后剩下的那个一定是出现次数最多的元素
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int count = 1, ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                ans = nums[i];
                count = 1;
                continue;
            }
            if(ans == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
