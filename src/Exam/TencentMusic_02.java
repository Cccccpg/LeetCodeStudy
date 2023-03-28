package Exam;

import java.util.HashSet;
import java.util.Set;

public class TencentMusic_02 {

    /**
     * 小红定义一个字符串的权值为:字符串长度乘以字符串的字母种类数量。例如，"abacb"的价值为5*3=15。
     * 小红拿到了一个字符串，她准备将该字符串切分成k个子串(将这k个子串按顺序拼在一起即可得到原串) 。
     * 小红希望切分后这k个子串的最大权值尽可能小。
     * 你能帮帮小红吗?你不需要给出一个方案，只需要返回最终这k个子串的最大权值即可。
     * 字符串仅包含小写字母，且长度不超过500000。k为不超过字符串长度的正整数。
     *
     * 输入："ababbbb",2
     * 输出:6
     *
     * 用动态规划来做这道题
     * 定义dp[i][j]表示将前j个字符分成i段的最大权值。
     * 当i = 1时，初始值是知道的，dp[1][j] = stringValue(substring(0, j))
     *
     *
     *
     * @param s
     * @param k
     * @return
     */
    public static int getMaxValue(String s, int k) {
        int n = s.length();
        int[][] dp = new int[k + 1][n + 1];  // dp[i][j]表示将前j个字符分成i段的最大权值

        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                if (i == 1) {
                    dp[i][j] = stringValue(s.substring(0, j));
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int p = i - 1; p < j; p++) {
                        Set<Character> set = new HashSet<>();
                        for (int q = p + 1; q <= j; q++) {
                            set.add(s.charAt(q - 1));
                        }
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][p] , set.size() * (j - p)));
                    }
                }
            }
        }
        return dp[k][n];
    }

    public static int stringValue(String str){
        int ans = 0;
        int[] dict = new int[26];
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (dict[c - 'a'] == 0){
                dict[c - 'a']++;
            }else{
                break;
            }
        }
        int sum = 0;
        for (int i : dict) {
            sum += i;
        }
        ans = sum * str.length();
        return ans;
    }

    public static void main(String[] args) {
        String s = "ababbbb";
        int k = 2;
        System.out.println(getMaxValue(s,k));
    }
}
