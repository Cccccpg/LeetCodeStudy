package DailyQuestion;

public class MergeAlternately {

    /**
     *
     * 给你两个字符串 word1 和 word2 。
     * 请你从 word1 开始，通过交替添加字母来合并字符串。
     * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
     *
     * 输入：word1 = "ab", word2 = "pqrs"
     * 输出："apbqrs"
     *
     * @param word1
     * @param word2
     * @return
     */

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len = word1.length() <= word2.length() ? word1.length() : word2.length();
        for (int i = 0; i < len; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (word1.length() == len){
            sb.append(word2.substring(len));
        }else {
            sb.append(word1.substring(len));
        }
        return sb.toString();
    }
}
