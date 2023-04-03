package Greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {

    /**
     * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
     *
     * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
     *
     * 返回一个表示每个字符串片段的长度的列表。
     *
     * 输入：s = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s){
        int[] dict = new int[26];
        // 遍历字符串，查看每个字母最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i) - 'a'] = i;
        }
        int left = 0, right = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, dict[s.charAt(i) - 'a']);
            // 如果最后出现的位置与该字母下标相等，那说明就已经到划分点了，后面没有该字母了
            if (right == i){
                res.add(right - left + 1);
                left = i + 1;
            }
        }
        return res;
    }
}
