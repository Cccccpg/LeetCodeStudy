package Sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 归并排序
     * @param nums
     * @return
     */
    private static void mergeSort(int[] nums, int low, int high) {
        if (low < high){
            int mid = (low + high) / 2;
            //归并左边
            mergeSort(nums, low, mid);
            //归并右边
            mergeSort(nums, mid + 1, high);
            //合并两边的数组
            merge(nums, low, mid, high);
        }
    }

    /**
     * 合并两个数组
     * @param nums
     * @param low
     * @param mid
     * @param high
     */
    private static void merge(int[] nums, int low, int mid, int high) {
        int[] arr = new int[high - low + 1];
        int index = 0;
        int left = low, right = mid + 1;
        //看谁小，谁就先放前面
        while(left <= mid && right <= high){
            if (nums[left] < nums[right]){
                arr[index++] = nums[left++];
            }else{
                arr[index++] = nums[right++];
            }
        }
        //如果左边还没合并完
        while(left <= mid){
            arr[index++] = nums[left++];
        }
        //如果右边还没合并完
        while (right <= high){
            arr[index++] = nums[right++];
        }
        //将合并好的结果放回原来的数组
        for (int i = 0; i < arr.length; i++) {
            nums[i + low] = arr[i];
        }
    }
}
