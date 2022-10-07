package Offer;

import java.util.Arrays;

public class Offer40 {

    /**
     * 就是排序，然后输出前k个元素
     *
     * @param arr
     * @param k
     * @return
     */

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }
}
