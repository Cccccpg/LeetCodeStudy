package LeetcodeHot100;

import java.util.Random;

public class FindKthLargest_215 {
    public int findKthLargest(int[] nums, int k) {
        qucikSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void qucikSort(int[] nums, int low, int high) {
        if (low < high){
            int position = partition(nums, low, high);
            qucikSort(nums, low, position - 1);
            qucikSort(nums, position + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int randomIndex = low + (int)(Math.random() * (high - low + 1));
        int pivot  = nums[randomIndex];
        int index = low;
        for (int i = low; i < high; i++) {
            if (nums[i] <= pivot){
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, high, index);
        return index;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
