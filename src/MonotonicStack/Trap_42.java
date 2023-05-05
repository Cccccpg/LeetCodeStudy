package MonotonicStack;

import java.util.Scanner;

public class Trap_42 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        System.out.println(trap(height));
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     *
     *
     * @param height
     * @return
     */
    public static int trap(int[] height){
        /* 暴力双指针
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            //第一根柱子和最后一根柱子不接水
            if (i == 0 || i == height.length - 1){
                continue;
            }
            int lHeight = height[i];
            int rHeight = height[i];
            //找左边最长的柱子
            for (int l = 0; l < i; l++){
                lHeight = Math.max(lHeight, height[l]);
            }
            //找右边最长的柱子
            for (int r = i + 1; r < height.length; r++){
                rHeight = Math.max(rHeight, height[r]);
            }
            int h = Math.min(lHeight, rHeight) - height[i];
            if (h > 0){
                ans += h;
            }
        }
        return ans;
         */
        if (height.length <= 2){
            return 0;
        }
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        //记录左边最大的
        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        //记录右边最大的
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--){
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0){
                ans += count;
            }
        }
        return ans;
    }
}
