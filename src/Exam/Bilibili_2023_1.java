package Exam;

import java.util.Arrays;
import java.util.Scanner;

public class Bilibili_2023_1 {
    /**
     *
     * 最近小强很喜欢玩一款勇士打怪的游戏，勇者和怪物都有一个属性: 能力值。当勇者遭遇一个怪物时战斗方式如下:
     * - 如果勇者的能力值不低于怪物的能力值，勇者胜
     * - 否则勇者败。
     * 勇者可以以任意顺序与怪物战斗，当勇者成功击败一只怪物后他可以获得一枚金币，
     * 初始时勇者金币数为 0，任意时刻勇者手中的金币数不能为负。
     * 勇者可以在任意时刻花费一枚金币，提升 1 点能力值。
     * 现在小强想知道，勇者手中最多可以有多少金币，怪物可以不打完。
     * 输入：
     * 1 3
     * 2 2 1
     * 输出：
     * 2
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        int coin = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (a >= nums[i]){
                coin++;
            }else{
                if (nums[i] - a <= coin){
                    coin = nums[i] - a;
                    a = nums[i];
                }else{
                    break;
                }
            }
            max = Math.max(coin, max);
        }
        System.out.println(max);
    }
}
