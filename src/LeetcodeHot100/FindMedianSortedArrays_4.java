package LeetcodeHot100;

public class FindMedianSortedArrays_4 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     *
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int index1 = 0, index2 = 0, index = 0, middle = len / 2 + 1;
        int[] nums = new int[len];
        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] <= nums2[index2]){
                nums[index] = nums1[index1];
                index1++;
            }else{
                nums[index] = nums2[index2];
                index2++;
            }
            index++;
        }
        if(index1 == nums1.length){
            while(index2 < nums2.length){
                nums[index] = nums2[index2];
                index2++;
                index++;
            }
        }else{
            while(index1 < nums1.length){
                nums[index] = nums1[index1];
                index1++;
                index++;
            }
        }
        double ans = 0;
        if((len & 1) == 1){
            ans = nums[middle - 1];
        }else{
            ans = (double) (nums[middle - 1] + nums[middle - 2]) / 2;
        }
        return ans;
    }
}
