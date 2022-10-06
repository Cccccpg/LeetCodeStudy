package Offer;

public class Offer53_1 {

    /**
     * 统计一个数字在数组中出现的次数
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     *
     * @param nums
     * @param target
     * @return
     */

    public static int search(int[] nums, int target) {
        int ans = 0;
        for (int num : nums) {
            if (num == target){
                ans++;
            }
        }
        return ans;
    }
}
