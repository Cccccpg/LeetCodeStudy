package DP;

import java.util.Scanner;

public class CountSubstrings_647 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(countSubstrings(str));
    }

    /**
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     *
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     *
     * 示例 1：
     * 输入："abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     *
     *
     * @param str
     * @return
     */
    public static int countSubstrings(String str){
        /* 方法一：DP
        boolean[][] dp = new boolean[str.length()][str.length()];
        dp[0][0] = false;
        int res = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if (j - i <= 1) {
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return res;
         */

        //方法二：双指针
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res += helper(str, i, i, str.length());
            res += helper(str, i, i + 1, str.length());
        }
        return res;
    }

    private static int helper(String str, int i, int j, int n) {
        int res = 0;
        while(i >= 0 && j < n && str.charAt(i) == str.charAt(j)){
            i--;
            j++;
            res++;
        }
        return res;
    }
}
