package LeetcodeHot100;

public class MinWindow_76 {

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
     *
     * 本质还是滑动窗口，
     * 移动right，直到全部包含t所需的字母
     * 然后再移动left，直到出现第一个t中的字母，此时right - left + 1就是覆盖子串的长度
     * 然后用size记录最小的子串长度，记下来start = left
     * 如此循环，最后返回最小的覆盖子串
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//需要字符c
                count--;
            }
            //把右边的字符加入窗口
            need[c]--;
            //窗口中已经包含所有字符
            if (count == 0) {
                while (l < r && need[s.charAt(l)] < 0) {
                    //释放左边不是要求的元素
                    need[s.charAt(l)]++;
                    //左指针右移
                    l++;
                }
                //不能右移时候挑选最小窗口大小，更新最小窗口开始的start
                if (r - l + 1 < size) {
                    size = r - l + 1;
                    //记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                    start = l;
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
