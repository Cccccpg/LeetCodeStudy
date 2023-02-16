package Interview;

public class Interview_01_01 {

    /**
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     *
     * 输入: s = "leetcode"
     * 输出: false
     *
     * https://leetcode.cn/problems/is-unique-lcci/
     *
     * 这种题用HashMap可以做，但是时间复杂度和空间复杂度会很高
     * 像这种判断字符是否相等，其实可以用数组来做，跟HashMap一样的做法
     *
     * @param astr
     * @return
     */

    public boolean isUnique(String astr) {
        int[] dict = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            if (dict[astr.charAt(i) - 'a'] == 0){
                dict[astr.charAt(i) - 'a']++;
            }else {
                return false;
            }
        }
        return true;
    }
}
