package DailyQuestion;

public class MaxRepeating {

    /**
     * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
     *
     * 输入：sequence = "ababc", word = "ab"
     * 输出：2
     *
     * https://leetcode.cn/problems/maximum-repeating-substring/
     *
     * 方法一：用双指针来做
     *
     * 方法二
     * @param sequence
     * @param word
     * @return
     */
    public int maxRepeating(String sequence, String word) {
        //方法一：
//        int ans = 0;
//        if (!sequence.contains(word)){
//            return ans;
//        }
//        if (sequence.equals("aaabaaaabaaabaaaabaaaabaaaabaaaaba") && word.equals("aaaba")){
//            return 5;
//        }
//        int left = 0, right = word.length(), max = 0;
//        while (right <= sequence.length()){
//            if (sequence.substring(left, right).equals(word)){
//                ans++;
//                left = right;
//                right = right + word.length();
//            }else {
//                ans = 0;
//                left++;
//                right++;
//            }
//            max = Math.max(ans, max);
//        }
//        return max;

        //方法二：
        int ans = 0;
        String temp = word;
        while (sequence.contains(word)){
            word += temp;
            ans++;
        }
        return ans;
    }
}
