package Offer;

public class Offer14_2 {

    /**
     * 与 14_1一样，只不过需要把int改为long就行
     *
     * @param n
     * @return
     */

    public int cuttingRope(int n) {
        if (n < 4){
            return n - 1;
        }
        long number3 = 0, lastNumber = 0, ans = 1;
        long remainder = n % 3;
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
            ans = ans % 1000000007;
        }
        if (lastNumber != 0){
            ans *= lastNumber;
            ans = ans % 1000000007;
        }
        return (int)ans;
    }
}
