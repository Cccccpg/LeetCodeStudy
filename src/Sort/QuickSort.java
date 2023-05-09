package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 7, 9, 2};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 快排，递归
     * @param nums
     * @param low
     * @param high
     */
    private static void quickSort(int[] nums, int low, int high) {
        if (low < high){
            int position = partition(nums, low, high);
            quickSort(nums, low, position - 1);
            quickSort(nums, position + 1, high);
        }
    }

    /**
     * 分区，返回每次分区的基值
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int index = low;
        for (int i = low; i < high; i++) {
            if (nums[i] <= pivot){
                swap(nums[i], nums[index]);
                index++;
            }
        }
        swap(nums[index], nums[high]);
        return index;
    }

    /**
     * 交换
     * @param num1
     * @param num2
     */
    public static void swap(int num1, int num2){
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
}
