package MonotonicStack;

import java.util.Arrays;
import java.util.Scanner;

public class NextGreaterElements_503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums){
        int[] newArr = Arrays.copyOf(nums, nums.length * 2);
        System.arraycopy(nums, 0, newArr, nums.length, nums.length);
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < newArr.length; j++) {
                if (nums[i] < newArr[j]){
                    ans[i] = newArr[j];
                    break;
                }
            }
        }
        return ans;
    }
}
