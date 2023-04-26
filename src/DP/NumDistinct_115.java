package DP;

import java.util.Scanner;

public class NumDistinct_115 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(numDistinct(s, t));
    }

    /**
     * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。
     * 题目数据保证答案符合 32 位带符号整数范围。
     *
     * 输入：s = "rabbbit", t = "rabbit"
     * 输出：3
     * 解释：
     * 如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
     * rabbbit
     * rabbbit
     * rabbbit
     *
     * 当s[i - 1] 与 t[j - 1]相等时，dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
     *
     * 当s[i - 1] 与 t[j - 1]不相等时，dp[i][j]只有一部分组成，不用s[i - 1]来匹配（就是模拟在s中删除这个元素），即：dp[i][j] = dp[i - 1][j];
     *
     * dp[i][0] 表示：以i-1为结尾的s可以随便删除元素，出现空字符串的个数。
     * 那么dp[i][0]一定都是1，因为也就是把以i-1为结尾的s，删除所有元素，出现空字符串的个数就是1。
     * dp[0][j] 表示：空字符串s可以随便删除元素，出现以j-1为结尾的字符串t的个数。
     * 那么dp[0][j]一定都是0，s如论如何也变成不了t。
     *
     * @param s
     * @param t
     * @return
     */
    public static int numDistinct(String s, String t){
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= t.length(); j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
