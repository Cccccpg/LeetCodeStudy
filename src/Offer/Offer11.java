package Offer;

public class Offer11 {

    /**
     *
     * 旋转数组的最小数字
     *
     *输入：numbers = [3,4,5,1,2]
     * 输出：1
     *
     * @param numbers
     * @return
     */

    public static int minArray(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            min = number < min ? number : min;
        }
        return min;
    }
}
