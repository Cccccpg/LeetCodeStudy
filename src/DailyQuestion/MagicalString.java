package DailyQuestion;

public class MagicalString {

    /**
     *
     * 神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
     *
     * 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
     * s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......" 。
     * 每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......" 。上面的出现次数正是 s 自身。
     *
     * 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
     *
     * 输入：n = 6
     * 输出：3
     * 解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。
     *
     * 链接：https://leetcode.cn/problems/magical-string
     *
     * 其实就相当于找规律，1,2是交替添加的，添加了1后添加2，添加了2后添加1，只是添加的个数不同而已
     *
     * str = “122”
     * i = 2, str = “122”，添加str[i] - '0' = 2个‘1’，str变为“12211”
     * i = 3, str = “12211”，添加str[i] - '0' = 1个‘2’，str变为“122112”
     * i = 4, str = “122112”，添加str[i] - '0' = 1个‘1’，str变为“1221121”
     * ...
     *
     * @param n
     * @return
     */

    public int magicalString(int n) {
        StringBuilder stringBuilder = new StringBuilder("122");
        for (int i = 2; stringBuilder.length() < n;){
            //判断需要添加几个‘1’或者‘2’
            for (int j = stringBuilder.charAt(i++) - '0'; j-- > 0; )
                stringBuilder.append('1');
            for (int j = stringBuilder.charAt(i++) - '0'; j-- > 0; )
                stringBuilder.append('2');
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (stringBuilder.charAt(i) == '1'){
                ans++;
            }
        }
        return ans;
    }
}
