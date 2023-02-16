package DailyQuestion;

public class DefuseTheBomb {

    /**
     *
     * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
     * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
     * 如果 k == 0 ，将第 i 个数字用 0 替换。
     *
     * 链接：https://leetcode.cn/problems/defuse-the-bomb
     *
     * 输入：code = [5,7,1,4], k = 3
     * 输出：[12,10,16,13]
     *
     * 就是分类讨论，找到公式
     *
     * @param code
     * @param k
     * @return
     */

    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if (k == 0){
            return ans;
        }else {
            for (int i = 0; i < code.length; i++) {
                int newNumber = 0;
                for (int j = 0; j < Math.abs(k); j++) {
                    if (k > 0){
                        newNumber += code[(i + j + 1) % code.length];
                    }else {
                        newNumber += code[(i - j - 1 + code.length) % code.length];
                    }
                }
                ans[i] = newNumber;
            }
        }
        return ans;
    }
}
