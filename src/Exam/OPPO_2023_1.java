package Exam;

import java.util.Scanner;

public class OPPO_2023_1 {

    /**
     * 小欧希望你构造一个二阶行列式，满足行列式中每个数均为不超过20的正整数，且行列式的值恰好等于x。你能帮帮她吗?
     *
     * 输入描述:
     * 一个正整数x。-1000<=x<=1000
     * 输出描述:
     * 如果无解，请输出-1。否则输出任意合法行列式即可(输出两行,每行输出两个不超过20的正整数)。
     *
     * 输入：2
     * 输出：
     * 3 2
     * 5 4
     *
     * 因为规定了每个数不超过20，所以直接四重循环暴力枚举
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for (int a = 1; a <= 20; a++) {
            for (int b = 1; b <= 20; b++) {
                for (int c = 1; c <= 20; c++) {
                    for (int d = 1; d <= 20; d++) {
                        if (a * d - c * b == x){
                            System.out.println(a + " " + b);
                            System.out.println(c + " " + d);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
