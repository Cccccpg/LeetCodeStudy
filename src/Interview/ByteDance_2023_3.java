package Interview;

import java.util.Scanner;

public class ByteDance_2023_3 {

    /**
     * 不同的二叉搜索树
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
     * 返回满足题意的二叉搜索树的种数。
     *
     * 关键在于如何找到规律
     * 任何一个二叉树都可以看做是由dp[0] dp[1]推导而来
     * dp[i]表示有i个元素的不同二叉搜索树的个数
     * dp[0]其实也可以看做是一个
     * dp[1] = 1
     * dp[2] = dp[0] * dp[1] + dp[1] * dp[0]
     * 其实就是左子树没有元素的情况 * 右子树有一个元素的情况 + 左子树有一个元素的情况 * 右子树没有元素的情况
     * 以此来进行递推
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        System.out.println(dp[n]);
    }
}
