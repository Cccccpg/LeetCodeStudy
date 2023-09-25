package Exam.Metajoy;

public class Exam_04 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            //第一根柱子和最后一根柱子不接水
            if (i == 0 || i == nums.length - 1){
                continue;
            }
            int leftMax = nums[i];
            int rightMax = nums[i];
            //找左边最长的柱子
            for (int l = 0; l < i; l++){
                leftMax = Math.max(leftMax, nums[l]);
            }
            //找右边最长的柱子
            for (int r = i + 1; r < nums.length; r++){
                rightMax = Math.max(rightMax, nums[r]);
            }
            int h = Math.min(leftMax, rightMax) - nums[i];

            if (h > 0){
                ans += h;
            }
        }
        System.out.println(ans);
    }
}
