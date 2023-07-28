package DP;

import sun.awt.image.GifImageDecoder;

import java.util.Scanner;

public class LongestCommonSubsequence_1143 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        String text2 = scanner.nextLine();
        System.out.println(printLongestCommonSubsequence(text1, text2));
    }

    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
     *
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     *
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
     *
     * 若这两个字符串没有公共子序列，则返回 0。
     *
     * 示例 1:
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace"，它的长度为 3。
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2){
        int[][] dp = new int[text1.length() + 1][text1.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    /**
     * 如果这一题改一下，要求输出最长公共子序列是啥
     */
    public static String printLongestCommonSubsequence(String text1, String text2){
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++){
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int count = dp[m][n];
        for (int i = m; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                if (dp[i][j] > dp[i - 1][j] && dp[i][j] > dp[i][j - 1]){
                    if (count == dp[i][j]){
                        sb.append(text1.charAt(i - 1));
                        count--;
                    }
                }
            }
        }
        return sb.reverse().toString();
    }
}
