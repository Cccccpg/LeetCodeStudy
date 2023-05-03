package MonotonicStack;

import Utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement_496 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] nums1 = new int[m];
        int[] nums2 = new int[n];
        for (int i = 0; i < m; i++) {
            nums1[i] = scanner.nextInt();
        }
        for (int j = 0; j < n; j++) {
            nums2[j] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        /* 方法1：暴力双循环
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int count = 0;
            int index = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]){
                    index = j;
                }
            }
            for (int j = index + 1; j < nums2.length; j++) {

                if (nums1[i] < nums2[j]){
                    count = nums2[j];
                    break;
                }
            }
            if (count == 0){
                res[i] = -1;
            }else{
                res[i] = count;
            }
        }
        return res;
         */

        //方法2：单调栈
        Stack<Integer> temp = new Stack<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], i);
        }
        temp.add(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[temp.peek()]){
                temp.add(i);
            }else{
                while (!temp.isEmpty() && nums2[temp.peek()] < nums2[i]){
                    if (hashMap.containsKey(nums2[temp.peek()])){
                        Integer index = hashMap.get(nums2[temp.peek()]);
                        res[index] = nums2[i];
                    }
                    temp.pop();
                }
                temp.add(i);
            }
        }
        return res;
    }
}
