package Offer;

public class Offer53_2 {
    /**
     *
     * 找到缺少的那个数
     *
     * 输入: [0,1,2,3,4,5,6,7,9]
     * 输出: 8
     *
     * @param nums
     * @return
     */

    public static int missingNumber(int[] nums) {
        int sum = ((0 + nums.length + 1) * nums.length + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
