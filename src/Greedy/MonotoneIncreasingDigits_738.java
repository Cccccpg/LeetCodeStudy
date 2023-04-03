package Greedy;

public class MonotoneIncreasingDigits_738 {

    /**
     * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
     *
     * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
     *
     * 输入: n = 332
     * 输出: 299
     *
     * 方法：从右边开始遍历，如果charArray[i] < charArray[i - 1]，比如2 < 3
     * 这时候就让 2 变成 9，然后再让charArray[i - 1]--，也就是3 - 1 = 2，变成329
     * 然后就是继续遍历数组，重复上面步骤，变成299，就是最后的正确答案
     *
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n){
        char[] charArray = String.valueOf(n).toCharArray();
        int flag = charArray.length;
        for (int i = charArray.length - 1; i > 0; i--) {
            if (charArray[i] < charArray[i - 1]){
                flag = i;
                charArray[i - 1]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < flag; i++) {
            sb.append(charArray[i]);
        }
        for (int i = flag; i < charArray.length; i++){
            sb.append('9');
        }
        return Integer.parseInt(sb.toString());
    }
}
