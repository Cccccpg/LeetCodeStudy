package Exam;

import java.util.Scanner;

public class DeWu_2023_1 {

    /**
     * 当字符串中有一串长度为x的连续子串，是回文串时，返回1，否则返回0
     *
     * 输入：
     * 6 2
     * AABCCD
     * 输出：
     * 1
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        boolean flag = Solution(str, x);
        if(flag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    /**
     * 滑动窗口为x，判断是否有长度为x的回文串
     * @param s
     * @param x
     * @return
     */
    public static boolean Solution(String s, int x) {
        int n = s.length();
        for (int i = 0; i <= n - x; i++) {
            if (isPalindrome(s.substring(i, i + x))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 中心扩散法判断子串是否为回文串
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
