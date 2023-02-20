package DailyQuestion;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxAverageRatio {

    /**
     *
     * 输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
     * 输出：0.78333
     * 解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-average-pass-ratio
     *
     * @param classes
     * @param extraStudents
     * @return
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        //(x+n)/(y+n) - x/y = (n*(y-x))/(y*(y+n));
        PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] > o2[0] ? -1 : 1);
        double num = 0D;
        for(int i=0; i<classes.length; i++){
            double u = (classes[i][1] - classes[i][0])/((double)classes[i][1]*(classes[i][1] + 1));
            pq.add(new double[]{u,i});
            num += ((double)classes[i][0]/classes[i][1]);
        }
        while(extraStudents > 0){
            int l = 1, r = extraStudents,mid = l + (r - l)/2;
            double[] res = pq.poll();
            double u = pq.peek()[0];
            while(l < r){
                double v = mid*((double)classes[(int)res[1]][1] - classes[(int)res[1]][0])/((double)classes[(int)res[1]][1]*(classes[(int)res[1]][1] + mid));
                double p = (mid-1)*((double)classes[(int)res[1]][1] - classes[(int)res[1]][0])/((double)classes[(int)res[1]][1]*(classes[(int)res[1]][1] + (mid-1)));
                if(v-p >= u) l = mid;
                else r = mid - 1;
                mid = l + (r - l + 1)/2;
            }
            num += mid*((double)classes[(int)res[1]][1] - classes[(int)res[1]][0])/((double)classes[(int)res[1]][1]*(classes[(int)res[1]][1] + mid));
            classes[(int)res[1]][0] += mid;
            classes[(int)res[1]][1] += mid;
            res[0] = (classes[(int)res[1]][1] - classes[(int)res[1]][0])/((double)classes[(int)res[1]][1]*(classes[(int)res[1]][1] + 1));
            extraStudents -= mid;
            pq.add(res);
        }
        return num/classes.length;
    }
}
