package Offer;

public class Offer17 {


    /**
     *
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
     *
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     *
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int max = 1;
        for (int i = 0; i < n; i++) {
            max *= 10;
        }
        max--;
        int[] ans = new int[max];
        for (int i = 0; i < max; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
