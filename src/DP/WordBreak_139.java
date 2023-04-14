package DP;

import java.util.List;

public class WordBreak_139 {

    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     *
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     *
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
     *
     * dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
     *
     * 如果确定dp[j] 是true，且 [j, i] 这个区间的子串出现在字典里，那么dp[i]一定是true。（j < i ）。
     *
     * 所以递推公式是 if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true。
     *
     * 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
     *
     * 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
     *
     * 而本题很明显是求排列
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i && !dp[i]; j++){
                if (wordDict.contains(s.substring(j, i)) && dp[j]);{
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
