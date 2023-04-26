package Exam;

import java.util.*;

public class Huawei_01 {

    /**
     * 服务器有三种运行状态:空载、单任务、多任务,每个时间片的能耗的分别为1、3、4;
     * 每个任务由起始时间片和结束时间片定义运行时间;
     * 如果一个时间片只有一个任务需要执行，则服务器处于单任务状态;
     * 如果一个时间片有多个任务需要执行，则服务器处于多任务状态;
     * 给定一个任务列表，请计算出从第一个任务开始，到所有任务结束,服务器的总能耗。
     * 输入为一个二维数组和二维数组的长度num，task[i][0]表示任务i的开始时间，task[i][1]表示任务i的结束时间，用贪心算法解这道题
     *
     * 示例1：
     * 输入：
     * 2
     * 2 5
     * 8 9
     * 输出：20
     *
     * @param args
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        int[][] tasks = new int[nums][2];
        for (int i = 0; i < nums; i++) {
            tasks[i][0] = scanner.nextInt();
            tasks[i][1] = scanner.nextInt();
        }

        // 记录每个时间片的状态
        int[] status = new int[1000000];
        // 记录所有任务的结束的最大时间，和开始的最小时间
        int maxTime = Integer.MIN_VALUE;
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < nums; i++) {
            maxTime = Math.max(maxTime, tasks[i][1]);
            minTime = Math.min(minTime, tasks[i][0]);
            for (int j = tasks[i][0]; j <= tasks[i][1]; j++) {
                status[j]++;
            }
        }
        int energy = 0;
        // 遍历整个状态矩阵
        for (int i = minTime; i <= maxTime; i++) {
            if (status[i] == 0){
                energy ++;                  // 空载状态
            }
            if (status[i] == 1) {           // 单任务状态
                energy += 3;
            } else if (status[i] > 1){      // 多任务状态
                energy += 4;
            }
        }
        System.out.println(energy);
    }
}
