package Offer;

import java.util.Arrays;

public class Offer03 {

    /**
     * 找出重复的数字
     *
     * 输入：[2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *
     * @param nums
     * @return
     */

    public static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]){
                return nums[i];
            }
        }
        return 0;
    }
}
