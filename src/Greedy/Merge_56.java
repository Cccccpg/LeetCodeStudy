package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_56 {
    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int rightBound = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > rightBound){
                res.add(new int[]{start, rightBound});
                start = intervals[i][0];
                rightBound = intervals[i][1];
            }else{
                rightBound = Math.max(rightBound, intervals[i][1]);
            }
        }
        res.add(new int[]{start, rightBound});
        return res.toArray(new int[res.size()][]);
    }
}
