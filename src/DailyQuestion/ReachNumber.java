package DailyQuestion;

public class ReachNumber {

    /**
     * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
     *
     * 你可以做一些数量的移动 numMoves :
     *
     * 每次你可以选择向左或向右移动。
     * 第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
     * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
     *
     * 链接：https://leetcode.cn/problems/reach-a-number
     *
     * 输入: target = 2
     * 输出: 3
     * 解释:
     * 第一次移动，从 0 到 1 。
     * 第二次移动，从 1 到 -1 。
     * 第三次移动，从 -1 到 2 。
     *
     * 使用数学方法，找到第一个sum，使得1+2+3+。。。+step >= target，并且sum - target 为偶数的step
     * 1、将所有的target为负数的情况转化为target为正数的情况
     * 2、向右走，知道当前sum > target，此时sum = 1+2+3+。。。+step。此时多走了a = sum - target
     * 3、只需要将前面的某一步值为 x = a / 2 的符号变成 “ - ”，就可以使得sum' = sum - a = target = 1+2+3+。。。-x+。。。+step

     * 4、其实就相当于sum' = target =  sum - 2x  ==> a = sum - target
     *  因为 sum = 1 + 2 + 3 + ... + x + step
     *      sum - x = 1 + 2 + 3 + ... + 0 + step
     *      sum - 2x = 1 + 2 + 3 + ... - x + step = sum' = target
     * 只需要判断 a 是否为偶数就行
     *
     * @param target
     * @return
     */
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0, step = 0;
        while (sum < target || (sum - target) % 2 != 0){
            step++;
            sum += step;
        }
        return step;
    }
}
