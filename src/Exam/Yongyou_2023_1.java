package Exam;

import java.math.BigInteger;
import java.util.Scanner;

public class Yongyou_2023_1 {

    /**
     * 大数相减
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);

        String ans = n1.subtract(n2).toString();
        System.out.println(ans);
    }
}
