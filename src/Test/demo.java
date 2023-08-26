package Test;

import java.util.Arrays;
import java.util.Scanner;

public class demo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] nums = new int[t];
        for (int i = 0; i < t; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < t; i++) {
            System.out.println(solution(nums[i]));
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long solution(int p) {
        if (p <= 1) {
            return 0;
        }

        long phi = p - 1;
        long ans = 1;
        for (int i = 2; i * i <= phi; i++) {
            if (phi % i == 0) {
                ans *= i - 1;
                phi /= i;
                while (phi % i == 0) {
                    ans *= i;
                    phi /= i;
                }
            }
        }
        if (phi > 1) {
            ans *= phi - 1;
        }
        return ans;
    }

}

