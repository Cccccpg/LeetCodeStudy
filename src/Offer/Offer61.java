package Offer;

import java.util.Arrays;

public class Offer61 {

    /**
     * 抽五张牌，判断这五张牌是不是顺子
     *
     * 输入: [0,0,1,2,5]
     * 输出: True
     *
     * 首先创建一个hashDict（用HashMap也可以，但是会比较麻烦）,用Hash数组字典来判断是否有重复的牌
     * 如果有重复的牌，一定不是顺子（0除外，遇到0就跳过）
     * 然后找最大值和最小值就行，
     * 如果max - min = 4说明里面没有0，也就是没有万能牌，
     * 如果max - min < 4,则说明里面有万能牌
     * 以上两种情况都可以构成顺子
     * 所以最后只要判断最大值 - 最小值 是否小于等于 4
     *
     * @param nums
     * @return
     */

    public boolean isStraight(int[] nums) {
        int[] hashDict = new int[14];
        int max = -1, min = 14;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                continue;
            }
            if (hashDict[nums[i]] >= 1){
                return false;
            }
            hashDict[nums[i]]++;
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        return max - min <= 4;
    }
}
