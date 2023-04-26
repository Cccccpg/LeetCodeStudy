package DP;

import java.util.Scanner;

public class MinDistance_583 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();
        System.out.println(minDistance(word1, word2));
    }

    /**
     * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
     *
     * 每步 可以删除任意一个字符串中的一个字符。
     *
     * 输入: word1 = "sea", word2 = "eat"
     * 输出: 2
     * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
     *
     * 其实就是找最长子序列，然后将两个字符串的长度相加然后相减就是可以删除的最小步数
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2){
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}
