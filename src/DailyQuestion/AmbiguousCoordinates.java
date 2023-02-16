package DailyQuestion;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {

    /**
     * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。
     * 返回所有可能的原始字符串到一个列表中。
     *
     * 输入: "(00011)"
     * 输出: ["(0.001, 1)", "(0, 0.011)"]
     * 解释: 0.0, 00, 0001 或 00.01 是不被允许的。
     *
     * 链接：https://leetcode.cn/problems/ambiguous-coordinates
     *
     * 将原先str中的左右两个括号去掉，变成新的s，新的长度为n
     * 枚举逗号的位置index，枚举的范围为[0, n - 1)，表示为在s[index]后添加逗号
     * 此时左边部分字符串为s[0, index],右边为s[index + 1, n - 1]
     * 实现一个搜索函数search(int start, int end)，该函数返回构造左右字符串的集合
     * 假设左边字符串s[0, index]搜索结果为A，右边字符串s[index + 1, n - 1]搜索的结果为B
     * 根据乘法原理，所有的实际方案为(x, y)，其中x属于A，y属于B
     *
     * 至于搜索函数search中，同样枚举追加小数点的位置，枚举范围为[start, end - 1]
     * 小数点前面的部分不能包含前导0，小数点后面的部分不能包含后导0
     *
     * @param s
     * @return
     */

    String s;
    public List<String> ambiguousCoordinates(String str) {
        s = str.substring(1, str.length() - 1);
        int n = s.length();
        List<String> ans = new ArrayList<>();
        //枚举逗号，在i后面追加逗号
        for (int i = 0; i < n - 1; i++) {
            List<String> left = search(0, i);
            List<String> right = search(i + 1, n - 1);
            for (String x : left) {
                for (String y : right) {
                    ans.add("(" + x + ", " + y + ")");
                }
            }
        }
        return ans;
    }

    private List<String> search(int start, int end) {
        List<String> ans = new ArrayList<>();
        if (start == end || s.charAt(start) != '0'){
            ans.add(s.substring(start, end + 1));
        }
        //枚举小数点，在i后面追加小数点
        for (int i = start; i < end; i++) {
            String left = s.substring(start, i + 1);
            String right = s.substring(i + 1, end + 1);
            if (left.length() > 1 && left.charAt(0) == '0'){
                continue;
            }
            if (right.charAt(right.length() - 1) == '0'){
                continue;
            }
            ans.add(left + "." + right);
        }
        return ans;
    }
}
