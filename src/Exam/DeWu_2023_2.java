package Exam;

import java.util.Arrays;
import java.util.Scanner;

public class DeWu_2023_2 {
    /**
     * 市容市貌建设是一个很重要的课题，在某市的规划中有这样一条要求，
     * 位于一条街道上的相邻位置的楼的高度差不能超过1m。每栋楼的高度都是整数。
     * 某同学第一次来到这个城市，他听人提起在一条街上，有n栋连续的建筑，这些建筑的总高度是m米，
     * 他想知道在这条街道上，第x栋建筑可能的最高高度是多少，不存在高度为0的建筑，也就是说这n栋建筑至少高1m
     * 1m.
     *
     * 输入：
     * 5 6 1
     * 输出：
     * 2
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        int count = 0;
        int ans = 1;
        m = m - n;
        while (m > 0) {
            int leftIndex = 0;
            if (x - count < 1){
                leftIndex = x - 1;
            }else{
                leftIndex = count;
            }
            int rightIndex = 0;
            if (x + count <= n){
                rightIndex = count;
            }else{
                rightIndex = n - x;
            }
            if (leftIndex + rightIndex + 1 <= m){
                ans++;
                m -= leftIndex + rightIndex + 1;
                count++;
            } else break;
        }
        System.out.println(ans);

    }
}
