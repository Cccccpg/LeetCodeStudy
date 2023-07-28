package Sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
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
            int leftPosition = position - 1;
            int rightPosition = position + 1;
            //去重
            while (leftPosition > low && nums[leftPosition] == nums[position]){
                leftPosition--;
            }
            while (rightPosition < high && nums[rightPosition] == nums[position]){
                rightPosition++;
            }
            quickSort(nums, low, leftPosition);
            quickSort(nums, rightPosition, high);
        }
    }

    /**
     * 分区，返回每次分区的基值
     * 注：这里是优化过的随机快排
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] nums, int low, int high) {
        //随机
        int randomIndex = low + (int)Math.random() * (high - low + 1);
        swap(nums, randomIndex, high);
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
