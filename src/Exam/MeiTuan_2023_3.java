package Exam;

import java.util.Arrays;
import java.util.Scanner;

public class MeiTuan_2023_3 {
    /**
     * 小美有一个长度为 n 的数组，她最多可以进行k次操作，每次操作如下:
     * 1.选择两个整数i,j
     * 2.选择两个整数x, y，使得x * y = ai * aj
     * 3.将ai替换为x，将aj替换为 y
     * 她希望最多进行k次操作之后，最后数组中的元素的总和尽可能大。
     * 输入描述
     * 第一行两个整数 n,k，表示数组的长度和操作的次数
     * 第二行n个整数表示数组的元素。
     * 输出描述
     * 输出一个整数，表示最后数组中的元素的总和的最大值，由于答案可能很大，你只需要输出答案对 10^9+ 7 取模的结果。
     * @param args
     */
    public static final int MOD = (int)1e9 + 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        long ans = 1;
        for (int i = n - 1; i >= n - k - 1; i--) {
            ans = (ans * nums[i]) % MOD;
        }
        ans += k;
        for (int i = 0; i < n - k - 1; i++){
            ans = (ans + nums[i]) % MOD;
        }
        System.out.println(ans);
    }
}
