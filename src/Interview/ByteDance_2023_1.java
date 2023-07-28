package Interview;

import java.util.Scanner;

public class ByteDance_2023_1 {

    /**
     * 力扣213题，打家劫舍
     *
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     *
     * 输入：nums = [1,2,3,1]  n = 4
     * 输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * 这题因为有环，所以可以拆分为两个数组，分别是[0, n-2],[1, n-1]
     * 因为如果偷第一个，那么肯定不能偷最后一个，同理，偷最后一个，肯定不能偷第一个
     * 所以可以拆成两个数组，分别计算能偷的最大值，然后再求最大
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] nums1 = new int[n - 1];
        int[] nums2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++){
            nums1[i] = nums[i];
        }
        for (int i = 1; i < n; i++){
            nums[i - 1] = nums[i];
        }
        int ans = Math.max(rob(nums1), rob(nums2));
        System.out.println(ans);
    }

    /**
     * 打家劫舍1
     * 就是dp，dp[i]表示到第i个房屋的最大能偷的钱
     * 每个房屋的状态都有两种，一种是偷，一种是不偷
     * 偷的话，那么前一个房屋肯定不能偷，所以dp[i] = dp[i - 2] + nums[i]
     * 不偷的话，那么这个房屋肯定不能偷，所以dp[i] = dp[i - 1]
     * 两者取最大值就可以
     * @param nums
     * @return
     */
    public static int rob(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
