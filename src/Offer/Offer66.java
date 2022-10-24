package Offer;

public class Offer66 {

    /**
     * 构建乘积数组
     *
     * 输入: [1,2,3,4,5]
     * 输出: [120,60,40,30,24]
     *
     *
     * @param a
     * @return
     */

    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] ans = new int[len];
        for (int i = 0, total = 1; i < len; total *= a[i], i++) {
            ans[i] = total;
        }
        for (int i = len - 1, total = 1; i >= 0; total *= a[i], i--) {
            ans[i] *= total;
        }
        return ans;
    }
}
