package Exam;

import java.util.Arrays;
import java.util.Scanner;

public class DeWu_2023_2 {
    /**
     * 导演在组织进行大运会开幕式的排练，其中一个环节是需要参演人员围成一个环形。
     * 演出人员站成了一圈，出于美观度的考虑，导演不希望某一个演员身边的其他人比他低太多或者高太多。
     * 现在给出n个参演人员的身高，
     * 问在他们站成一圈时，相邻演员的身高差的最大值至少是多少?
     *
     * 输入：
     * 5
     * 2 1 1 3 2
     * 输出：
     * 1
     *
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
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int ans = 0;
        int n = nums.length;
        if (n == 2){
            return nums[1] - nums[0];
        }
        int[] arr = new int[n];
        Arrays.sort(nums);
        int oddAns = Integer.MIN_VALUE;
        for (int i = 2; i < n; i += 2){
            oddAns = Math.max(nums[i] - nums[i - 2], oddAns);
        }
        int evenAns = Integer.MIN_VALUE;
        for (int i = 3; i < n; i += 2){
            evenAns = Math.max(nums[i] - nums[i - 2], evenAns);
        }
        ans = Math.max(nums[1] - nums[0], Math.max(oddAns, evenAns));
        return ans;
    }
}
