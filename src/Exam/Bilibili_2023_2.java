package Exam;

import java.util.Scanner;

public class Bilibili_2023_2 {
    /**
     * 小红计划在m天刷n道题，第i天计划刷ai题。
     * 小红会严格按照计划刷题，到第i天时，小红会评估剩下平均每天需要刷t题。
     * 若ai大于t，则记录>;
     * 若等于t，则记录=;
     * 若ai小于t，则记录<。
     * 请你输出小红的评估记录。
     *
     * 输入：
     * 15 6
     * 4 5 0 3 1 2
     * 输出：
     * >><><=
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[m];
        char[] ans = new char[m];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        int count = n;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += nums[i];
            count -= sum;
            int avg = 0;
            int temp = 0;
            for (int j = i + 1; j < m; j++){
                temp += nums[j];
            }
            if (i == m - 1){
                ans[i] = '=';
            }else{
                avg = temp / (m - i - 1);
                if (nums[i] > avg){
                    ans[i] = '>';
                }else if (nums[i] < avg){
                    ans[i] = '<';
                }else{
                    ans[i] = '=';
                }
            }

        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
    }
}
