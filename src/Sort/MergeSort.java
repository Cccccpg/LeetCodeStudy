package Sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 7, 9, 2, 1, 7, 1, 7, 2};
        System.out.println(Arrays.toString(mergeSort(nums)));
    }

    /**
     * 归并排序
     * @param nums
     * @return
     */
    private static int[] mergeSort(int[] nums) {
        if (nums.length <= 1){
            return nums;
        }
        int middle = nums.length / 2;
        int[] numsLeft = Arrays.copyOfRange(nums, 0, middle);
        int[] numsRight = Arrays.copyOfRange(nums, middle, nums.length);
        return merge(mergeSort(numsLeft), mergeSort(numsRight));
    }

    private static int[] merge(int[] numsLeft, int[] numsRight) {
        int[] ansArr = new int[numsLeft.length + numsRight.length];
        int left = 0, right = 0, index = 0;
        // 对比
        while (left < numsLeft.length && right < numsRight.length){
            if (numsLeft[left] < numsRight[right]){
                ansArr[index] = numsLeft[left];
                left++;
            }else{
                ansArr[index] = numsRight[right];
                right++;
            }
            index++;
        }
        // 左边子序列的长度比右边子序列的长度更长
        if (left < numsLeft.length){
            while (left < numsLeft.length){
                ansArr[index] = numsLeft[left];
                left++;
                index++;
            }
        }else {
            while (right < numsRight.length){
                ansArr[index] = numsRight[right];
                right++;
                index++;
            }
        }
        return ansArr;
    }
}
