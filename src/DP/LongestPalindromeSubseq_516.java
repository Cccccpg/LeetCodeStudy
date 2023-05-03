package DP;

import java.util.Scanner;

public class LongestPalindromeSubseq_516 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(longestPalindromeSubseq(str));
    }

    /**
     * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
     *
     * 示例 1: 输入: "bbbab" 输出: 4 一个可能的最长回文子序列为 "bbbb"。
     * 示例 2: 输入:"cbbd" 输出: 2 一个可能的最长回文子序列为 "bb"。
     *
     * 注：回文串是要求连续的，但是回文子序列是不要求连续的
     *
     * 这题还有一种解法就是反转字符串，然后将两个字符串求最长公共子序列
     *
     * @param str
     * @return
     */
    public static int longestPalindromeSubseq(String str){
        int[][] dp = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][str.length() - 1];
    }
}
