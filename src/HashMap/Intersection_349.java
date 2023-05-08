package HashMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Intersection_349 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] nums1 = new int[m];
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }

        int n = sc.nextInt();
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }
        System.out.println(intersection(nums1, nums2));
    }

    /**
     * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     * 解释：[4,9] 也是可通过的
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2){
        List<Integer> ans = new ArrayList<>();
        int[] dict1 = new int[1001];
        int[] dict2 = new int[1001];
        for (int num : nums1) {
            if (dict1[num] == 0){
                dict1[num]++;
            }
        }
        for (int num : nums2) {
            if (dict2[num] == 0){
                dict2[num]++;
            }
        }
        for (int i = 0; i < 1001; i++) {
            if (dict1[i] != 0 && dict2[i] != 0 && dict1[i] == dict2[i]){
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }
}
