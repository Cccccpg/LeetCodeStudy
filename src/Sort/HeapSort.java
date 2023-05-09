package Sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 7, 9, 2, 1, 7, 1, 7, 2};
        System.out.println(Arrays.toString(heapSort(nums)));
    }

    // 全局变量，用来记录当前堆的长度
    public static int heapLen;

    /**
     * 堆排序
     * @param nums
     * @return
     */
    public static int[] heapSort(int[] nums) {
        heapLen = nums.length;
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapLen--;
            heapify(nums, 0);
        }
        return nums;
    }

    /**
     * 建立大顶堆
     * @param nums
     */
    private static void buildMaxHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, i);
        }
    }

    /**
     * 调整大顶堆
     * @param nums
     * @param i
     */
    private static void heapify(int[] nums, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < heapLen && nums[left] > nums[largest]){
            largest = left;
        }
        if (right < heapLen && nums[right] > nums[largest]){
            largest = right;
        }
        if (largest != i){
            swap(nums, i, largest);
            heapify(nums, largest);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
