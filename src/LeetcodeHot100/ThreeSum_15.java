package LeetcodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if(nums[0] > 0 || nums[nums.length - 1] < 0){
            return ans;
        }
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            if(nums[i] > 0){
                return ans;
            }
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int target = nums[i] + nums[left] + nums[right];
                if(target == 0){
                    addToList(nums, i, left, right);
                    //去重
                    while(left < right && nums[left + 1] == nums[left]){
                        left++;
                    }
                    while(left < right && nums[right - 1] == nums[right]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(target > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }

    public static void addToList(int[] nums, int a, int b, int c){
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[a]);
        temp.add(nums[b]);
        temp.add(nums[c]);
        ans.add(temp);
    }
}
