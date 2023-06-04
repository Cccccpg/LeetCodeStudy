package Sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        long start = System.nanoTime();
        quickSort(nums, 0, nums.length - 1);
        long end = System.nanoTime();
        System.out.println(end - start);
        System.out.println(nums[nums.length - 2]);
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
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, index, high);
        return index;
    }

    /**
     * 交换
     *
     */
    public static void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
