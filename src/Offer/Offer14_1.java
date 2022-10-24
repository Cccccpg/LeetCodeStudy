package Offer;

public class Offer14_1 {

    /**
     *
     * 其实就是分类，将n % 3按照余数分为三类
     * 1、余数为0，那么就number3个3相乘
     * 2、余数为1，那么就number3 - 1个3相乘，再乘4
     * 3、余数为2，那么久number3个3相乘，再乘2
     *
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     *
     * @param n
     * @return
     */

    public int cuttingRope(int n) {
        if (n < 4){
            return n - 1;
        }
        int number3 = 0, lastNumber = 0, ans = 1;
        int remainder = n % 3;
        if (remainder == 0){
            number3 = n / 3;
        }else if (remainder == 1){
            number3 = n / 3 - 1;
            lastNumber = 4;
        }else if (remainder == 2){
            number3 = n / 3;
            lastNumber = 2;
        }
        for (int i = 0; i < number3; i++) {
            ans *= 3;
        }
        if (lastNumber != 0){
            ans *= lastNumber;
        }
        return ans;
    }
}
