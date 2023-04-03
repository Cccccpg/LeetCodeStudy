package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals_435 {

    /**
     * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
     * 返回 需要移除区间的最小数量，使剩余区间互不重叠 。
     *
     * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
     * 输出: 1
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            // 找重叠的个数
            if (intervals[i][0] < intervals[i - 1][1]){
                count++;
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
            }
        }
        return count;
    }
}
