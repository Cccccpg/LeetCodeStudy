package DailyQuestion;

public class TotalFruit {

    /**
     * 找数组中只有两种元素的最长子序列的长度
     *
     * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
     * 输出：5
     *
     * 用滑动窗口来做
     * 维护left和right，每次取两个数，right向右滑动
     * 如果fruits[right]是第三个数，那么就更新新的数，将left移动到right前一位
     * 然后再将left向前移动，一直找到最前面的那个相等的位置，更新ans
     * 如果fruits[right]是两个数中的，那么直接更新ans
     *
     * @param fruits
     * @return
     */

    public int totalFruit(int[] fruits) {
        int left = 0, right = 0, ans = 0;
        int leftNumber = fruits[left], rightNumber = fruits[right];
        while (right < fruits.length){
            if (fruits[right] == leftNumber || fruits[right] == rightNumber){
                ans = Math.max(ans, right + 1 - left);
                right++;
            }else {
                left = right - 1;
                leftNumber = fruits[left];
                while (left >= 1 && fruits[left - 1] == leftNumber){
                    left--;
                }
                rightNumber = fruits[right];
                ans = Math.max(ans, right + 1 - left);
            }
        }
        return ans;
    }
}
