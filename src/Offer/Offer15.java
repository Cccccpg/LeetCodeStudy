package Offer;

public class Offer15 {

    /**
     * 暴力求解
     * @param n
     * @return
     */

    public int hammingWeight(int n) {
        String newNumber = Integer.toBinaryString(n);
        int ans = 0;
        for (int i = 0; i < newNumber.length(); i++) {
            if (newNumber.charAt(i) == '1'){
                ans++;
            }
        }
        return ans;

        /*
        return Integer.bitCount(n);
         */
    }
}
