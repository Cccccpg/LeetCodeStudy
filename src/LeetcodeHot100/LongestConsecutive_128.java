package LeetcodeHot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutive_128 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(longestConsecutive(nums));
    }

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums){
        //这种做法时间复杂度为O(nlogn)，不符合要求
//        if (nums.length <= 1) {
//            return nums.length;
//        }
//        Arrays.sort(nums);
//        int index = 1;
//        int count = 1, ans = 0;
//        while (index < nums.length){
//            if (nums[index - 1] + 1 == nums[index]){
//                count++;
//                if (index == nums.length - 1){
//                    ans = Math.max(ans, count);
//                    break;
//                }
//                index++;
//            }else if (nums[index - 1] == nums[index]){
//                index++;
//            }else{
//                index++;
//                ans = Math.max(ans, count);
//                count = 1;
//            }
//
//        }
//        return ans;
        //用HashSet做
        HashSet<Integer> hashSet = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            hashSet.add(num);
        }
        for (Integer set : hashSet) {
            if (!hashSet.contains(set - 1)){
                int cur = set;
                int len = 1;
                while (hashSet.contains(cur + 1)){
                    cur++;
                    len++;
                }
                ans = Math.max(len, ans);
            }
        }
        return ans;
    }
}
