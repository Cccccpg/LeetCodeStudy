package Offer;

import java.util.Arrays;
import java.util.HashMap;

public class Offer39 {

    /**
     * 两个方法，
     * 1、用HashMap来做
     * 2、用中位数来做，因为如果有一个数的个数大于长度的一半，那说明中位数一定是那个数
     * @param nums
     * @return
     */

    public int majorityElement(int[] nums) {

        //方法一：HashMap
        /*HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.get(integer) > nums.length / 2){
                return integer;
            }
        }
        return 0;*/

        //方法二：中位数
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
