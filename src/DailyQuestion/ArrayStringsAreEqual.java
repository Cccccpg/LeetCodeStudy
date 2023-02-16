package DailyQuestion;

public class ArrayStringsAreEqual {

    /***
     * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
     *
     * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
     * 输出：true
     *
     * https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/
     *
     * 简单题没什么好说的
     * @param word1
     * @param word2
     * @return
     */

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }
}
