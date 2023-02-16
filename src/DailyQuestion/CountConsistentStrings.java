package DailyQuestion;

public class CountConsistentStrings {

    /**
     * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。
     * 如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
     * 请你返回 words 数组中 一致字符串 的数目。
     *
     * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
     * 输出：2
     * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
     *
     * 链接：https://leetcode.cn/problems/count-the-number-of-consistent-strings
     *
     * 没什么说的，简单题，可以用HashMap来做，但是时间复杂度会更高
     * 对于这种固定字母的题目，不如用数组来模拟Hash表更简单，也更快
     * 然后就是判断每个words中的word的每个字母是不是在字典中出现过，都没出现过就让ans + 1
     * 最后返回就行
     *
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        int[] dict = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            dict[allowed.charAt(i) - 'a']++;
        }
        for (String word : words) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (dict[word.charAt(i) - 'a'] != 1){
                    break;
                }else {
                    count++;
                }
            }
            if (count == word.length()){
                ans++;
            }
        }
        return ans;
    }
}
