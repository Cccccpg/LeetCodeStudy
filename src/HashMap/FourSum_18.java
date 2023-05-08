package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FourSum_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(fourSum(nums, target));
    }

    /**
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
     * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
     *
     * 0 <= a, b, c, d < n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     *
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if (nums[i] > target && nums[i] >= 0){
                break;
            }
            //对nums[i]去重
            if (i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                //继续剪枝
                if (nums[i] + nums[j] > target && nums[j] >= 0){
                    break;
                }
                //对nums[j]去重
                if (j > i + 1 && nums[j - 1] == nums[j]){
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        ansList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        //找到答案时，双指针同时收缩
                        left++;
                        right--;
                    }else if (sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return ansList;
    }
}
