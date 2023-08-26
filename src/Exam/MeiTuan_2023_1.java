package Exam;

import java.util.Scanner;

public class MeiTuan_2023_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        System.out.println(Solution(x, y, z));
    }

    public static int Solution(int x, int y, int z){
        int sum = 0;
        boolean flag = true;
        int ans = 0;
        while(sum < z){
            if (ans % 3 == 0){
                flag = true;
            }
            sum += x;
            if (flag){
                sum += y;
                flag = false;
            }
            ans++;
        }
        return ans;
    }
}
