package LeetcodeHot100;

public class ProductExceptSelf_238 {
    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        // 方法一：用除法，时间复杂度O(n)，空间复杂度O(1)
//        int temp = 1, count = 0;
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] == 0){
//                count++;
//                continue;
//            }
//            if(count >= 2){
//                temp = 0;
//                break;
//            }
//            temp *= nums[i];
//        }
//        for(int i = 0; i < nums.length; i++){
//            if(count == 1){
//                if(nums[i] == 0){
//                    nums[i] = temp;
//                }else{
//                    nums[i] = 0;
//                }
//            }else if(count >= 2){
//                nums[i] = 0;
//            }else{
//                nums[i] = temp / nums[i];
//            }
//        }

        //方法二：不用除法，时间复杂度O(n)
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        for(int i = 1; i < nums.length; i++){
            left[i] = nums[i - 1] * left[i - 1];
        }
        right[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            right[i] = nums[i + 1] * right[i + 1];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}
