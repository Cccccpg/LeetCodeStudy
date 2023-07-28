package Exam;

import java.util.Scanner;

public class OPPO_2023_2 {

    /**
     * 小欧正在一个回合制格斗游戏中挑战一个boss。已知游戏的0/3机制如下:
     *
     * 每回合小欧先手攻击boss，然后boss攻击小欧，此时1回合结束。
     * 小欧有时可以闪避boss的攻击，当闪避成功时这回合将不受boss的伤害。
     * 小欧攻击boss时可以攒“连击点”，她攻击造成的伤害为 a + k b，
     * 其中a为基础攻击力，b为基础连击伤害，k为连击次数。
     * 小欧每次攻击后会让连击次数加1，但当受到boss的伤害后会重置连击次数为0。
     *
     * 小欧想知道，她最终共对boss造成了多少伤害?
     *
     * 输入描述:
     * 第一行输入三个正整数n,a,b，代表回合的数量，小欧基础攻击力，小欧的基础连击伤害。
     * 第二行输入一个长度为n的字符串，字符串仅由o和x组成，其中o代表本回合闪避成功，x代表本回合闪避失败。
     * 1<=n,a,b<=10^5
     * 输出描述:
     * 一个正整数，代表小欧造成的伤害总和。
     *
     * 输入：
     * 3 5 2
     * oxo
     * 输出：
     * 17
     * 第一回合攻击，连击次数为0，造成5点伤害。攻击后连击次数变成1。小欧闪避成功。
     * 第二回合攻击，连击次数为1，造成7点伤害。攻击后连击次数变成2.小欧闪避失败，连击次数为0。
     * 第三回合攻击，连击次数为0，造成5点伤害。攻击后连击次数变成1。小欧闪避成功。
     * 总共造成17点伤害。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();      //一定要用这个分割开输入

        String str = sc.nextLine();
        int k = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            ans += a + k * b;
            if (str.charAt(i) == 'o'){
                k++;
            }else{
                k = 0;
            }
        }
        System.out.println(ans);
    }
}
