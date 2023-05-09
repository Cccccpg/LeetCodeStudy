package Sort;

import java.util.Arrays;

public class BubbleSort {
    /**
     * 冒泡排序，从小到大
     * nums = [1,8,6,7,9,2];
     * @param nums
     */
    public static int[] bubbleSort(int[] nums){
        for(int i = nums.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 7, 9, 2};
        System.out.println(Arrays.toString(bubbleSort(nums)));
    }
}
