package Interview;

import java.util.*;

public class ByteDance_2023_2 {

    /**
     * 力扣原题，合并区间
     *
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     *
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++){
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < n; i++){
            if (end < intervals[i][0]){
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }else{
                end = Math.max(intervals[i][1], end);
            }
        }
        ans.add(new int[]{start, end});
        ans.toArray(new int[ans.size()][]);
    }
}
