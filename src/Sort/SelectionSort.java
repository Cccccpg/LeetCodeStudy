package Sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 7, 9, 2, 1, 7, 1, 7, 2};
        System.out.println(Arrays.toString(selectionSort(nums)));
    }

    /**
     * 选择排序，从小到大
     * @param nums
     * @return
     */
    public static int[] selectionSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE, index = 0;
            for (int j = i; j < nums.length; j++){
                if (nums[j] < min){
                    min = nums[j];
                    index = j;
                }
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}
