package Exam;
import java.util.*;

public class Mihoyo_2023_1 {
    /**
     * 米小游和奥托主教冲虚树之树后，掉入量子之海里失散了，但她不知道奥托主教在哪里，所以她决定先去寻找月下，再让月下带着她一起去找奥托主教。
     * 已知量子之海可以认为是一个n* m的矩阵，左下角坐标为(1,1)，右上角坐标是(n,m)。
     * 米小游每次可以走到相邻的坐标，即当|x1-x2|十|y1 -y2|= 1时，米小游可以从(x1,y1)走到(x2,y2)。
     * 另外，量子之海有一个特殊的特性，其左边界和右边界是相邻的，上边界和下边界也是相邻的。
     * 也就是说，(x,1)和(x,m) 相邻，(1,y)和(n,y)也是相邻的。
     * 现在按顺序给定了米小游、月下和奥托主教的坐标，请你判断米小游最少需要走几步。
     *
     * 输入描述:
     * 第一行输入两个整数n,m(1<=n,m<=10^9)表示量子之海大小。
     * 接下来三行，每行输入两个整数x(1 <=x<=n),y(1<=y<=m)表示米小游、月下和奥托主教的坐标。
     *
     * 输出描述:
     * 输出一个整数表示最少需要走的步数。
     *
     * 思路：
     * 走的路径是(x1, y1) -> (x2, y2) -> (x3, y3)
     * 而且每次移动只会改变x或者y，所以可以独立进行考虑考虑×1移动到×2时,怎样才能最短就行
     * 有两种走法,要么顺着走,要么逆着走
     * 因此两个分别计算，然后取最小值即可
     * 然后将x1 -> x2, x2 -> x3, y1 -> y2, y2 -> y3加起来就行
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        System.out.println(calc(x1, x2, n) + calc(x2, x3, n) + calc(y1, y2, m) + calc(y2, y3, m));
    }

    private static int calc(int a, int b, int n) {
        int v = Math.abs(a - b);
        return Math.min(v, n - v);
    }
}
