package Offer;

import java.util.ArrayList;
import java.util.List;

public class Offer57_2 {

    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * 暴力双循环+滑动窗口
     * 如果sum > target，那么left++;
     * 如果sum = target,那么将从left到right的值输入数组，添加到list中
     * 如果sum < target，那么right++;
     * 最后将list集合输入到答案数组中
     *
     * 输入：target = 15
     * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
     *
     * @param target
     * @return
     */

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for (int left = 1, right = 1, sum = 0; right < target; right++){
            sum += right;
            while (sum > target) {
                sum -= left;
                left++;
            }
            if (sum == target){
                int[] ans = new int[right - left + 1];
                for (int i = left; i <= right; i++){
                    ans[i - left] = i;
                }
                list.add(ans);
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
